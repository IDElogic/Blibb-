package se.android.blibb.presentation.screen.recipe.details

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import se.android.blibb.presentation.screen.recipe.model.Recipe
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.wheat
import se.android.blibb.ui.theme.zuzmo
import kotlin.math.PI

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalFoundationApi::class)
@Composable
fun RecipeDetails(
    recipe: Recipe,
    goBack: () -> Unit,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransactionScope: SharedTransitionScope)
{
    val imageRotation = remember { mutableIntStateOf(0) }

    val toolbarOffsetHeightPx = remember { mutableFloatStateOf(340f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset, source: NestedScrollSource
            ): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.floatValue + delta
                toolbarOffsetHeightPx.floatValue = newOffset.coerceIn(0f, 340f)
                imageRotation.intValue += (available.y * 0.5).toInt()
                return Offset.Zero
            }

            override fun onPostScroll(
                consumed: Offset, available: Offset, source: NestedScrollSource
            ): Offset {
                val delta = available.y
                imageRotation.intValue += ((delta * PI / 180) * 10).toInt()
                return super.onPostScroll(consumed, available, source)
            }

            override suspend fun onPreFling(available: Velocity): Velocity {
                imageRotation.intValue += available.y.toInt()
                return super.onPreFling(available)
            }
        }
    }

    val candidateHeight = maxOf(toolbarOffsetHeightPx.floatValue, 300f)
    val listState = rememberLazyListState()
    val (fraction, setFraction) = remember { mutableFloatStateOf(1f) }

    with(sharedTransactionScope)
    {
        if (sharedTransactionScope.isTransitionActive.not()) {
            setFraction(0f) }
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = if (recipe.bgColor == wheat) zuzmo else wheat))
        {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(nestedScrollConnection),
                state = listState)
            {
                stickyHeader {
                    Box(
                        modifier = Modifier.shadow(
                            elevation = if (fraction < 0.05) {
                                ((1 - fraction) * 16).dp
                            } else 0.dp,
                            clip = false,
                            ambientColor = Ros.copy(if (fraction < 0.1) 1f - fraction else 0f),
                            spotColor = Ros.copy(if (fraction < 0.1) 1f - fraction else 0f)
                        ).alpha(if (fraction < 0.2) 1f - fraction else 0f).fillMaxWidth()
                            .background(
                                recipe.bgColor,
                                RoundedCornerShape(
                                    bottomEnd = 35.dp, bottomStart = 35.dp
                                ),
                            ).clip(RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp))
                            .height(candidateHeight.dp).then(
                                Modifier.sharedElement(
                                    rememberSharedContentState(
                                        key = "item-container-${recipe.id}"
                                    ),
                                    animatedVisibilityScope,
                                )
                            ),
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            recipe.bgImage?.let {
                                Image(painter = painterResource(it),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .graphicsLayer {
                                            scaleX = 1.050f
                                            scaleY = 1.050f
                                        }.blur(radius = 8.dp),
                                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(
                                        MDark.copy(alpha = 0.3f)
                                    )
                                )
                                Image(painter = painterResource(it),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .background(
                                            Color.Transparent,
                                            RoundedCornerShape(
                                                bottomEnd = DIMENS_20dp, bottomStart = DIMENS_20dp
                                            ),
                                        )
                                        //  .offset {}
                                        .graphicsLayer {
                                            shadowElevation = 8f
                                            scaleX = 1.050f
                                            scaleY = 1.050f
                                        },
                                    alpha = 1 - fraction
                                )
                            }
                            Box(
                                modifier = Modifier.aspectRatio(1f).align(Alignment.Center)
                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(recipe.image),
                                        contentDescription = null,
                                        modifier = Modifier.aspectRatio(1f).align(Alignment.Center)
                                            .windowInsetsPadding(WindowInsets.systemBars)
                                            .padding(16.dp).rotate(imageRotation.intValue.toFloat())
                                            .background(
                                                Color.Transparent,
                                                CircleShape,
                                            ).sharedBounds(
                                                rememberSharedContentState(key = "item-image-${recipe.id}"),
                                                animatedVisibilityScope = animatedVisibilityScope,
                                                enter = fadeIn(),
                                                exit = fadeOut(),
                                                resizeMode = SharedTransitionScope.ResizeMode.ScaleToBounds()
                                            )
                                    )
                                }
                            }
                        }
                    }
                }
                StepsAndDetails(
                    sharedTransactionScope = sharedTransactionScope,
                    animatedVisibilityScope = animatedVisibilityScope,
                    recipe = recipe
                )
            }

            Box(modifier = Modifier
                .windowInsetsPadding(WindowInsets.systemBars)
                .size(50.dp)
                .padding(10.dp)
                .alpha(
                    alpha = if (fraction <= 0) 1f else 0f,)
                .background(
                    color = MDark, shape = RoundedCornerShape(50))
                .shadow(elevation = 16.dp).padding(5.dp).clickable {
                    goBack()
                }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null,
                    tint = recipe.bgColor,
                    modifier = Modifier
                        .size(DIMENS_20dp)
                )
            }
        }
    }
}
