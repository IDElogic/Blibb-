@file:OptIn(ExperimentalFoundationApi::class)

package se.android.blibb.presentation.screen.settings

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay
import se.android.blibb.R
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_80dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat


@SuppressLint("ContextCastToActivity")
@Composable
fun SettingsMainScreen(
    navController: NavController,
) {
    LocalContext.current as Activity
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(horizontal = DIMENS_20dp, vertical = DIMENS_32dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
                .padding(DIMENS_20dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Card(
                    border = BorderStroke(1.dp, color = Black.copy(0.46f)),
                    shape = RoundedCornerShape(50.dp),

                    ) {
                    Image(
                        modifier = Modifier
                            .height(DIMENS_68dp)
                            .width(DIMENS_68dp),
                        painter = painterResource(id = R.drawable.bg_b),
                        contentScale = ContentScale.Crop,
                        contentDescription = "image"
                    )
                }
                Spacer(modifier = Modifier.width(DIMENS_20dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                ) {
                    Text(
                        text = "Settings",
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = TEXT_SIZE_1sp,
                    )
                    Spacer(modifier = Modifier.width(DIMENS_8dp))
                }
            }

            NeuButton(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DIMENS_80dp)
                    .padding(horizontal = 10.dp)
                    .border(1.dp, Black, RoundedCornerShape(50.dp)),
                lightColor = Black,
                onClick = {
                    navController.navigate(Screen.ProfileSettings.route)
                }
            ) {
                Row {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Profile settings",
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_12sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp,
                            color = wheat.copy(0.66f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(DIMENS_20dp),
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "arrow_right",
                            tint = Ros
                        )
                    }
                }
            }

            NeuButton(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DIMENS_80dp)
                    .padding(horizontal = 10.dp)
                    .border(1.dp, Black, RoundedCornerShape(50.dp)),
                lightColor = Black,
                onClick = {
                    navController.navigate(Screen.NotificationSettings.route)
                }
            ) {
                Row {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Notifications settings",
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_12sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp,
                            color = wheat.copy(0.66f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(DIMENS_20dp),
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "arrow_right",
                            tint = Ros
                        )
                    }
                }
            }
            NeuButton(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DIMENS_80dp)
                    .padding(horizontal = 10.dp)
                    .border(1.dp, Black, RoundedCornerShape(50.dp)),
                lightColor = Black,
                onClick = {
                    navController.navigate(Screen.AppearanceSettings.route)
                }
            ) {
                Row {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Only UI Playground",
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_12sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp,
                            color = wheat.copy(0.66f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(DIMENS_20dp),
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "arrow_right",
                            tint = Ros
                        )
                    }
                }
            }

            NeuButton(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DIMENS_80dp)
                    .padding(horizontal = 10.dp)
                    .border(1.dp, Black, RoundedCornerShape(50.dp)),
                lightColor = Black,
                onClick = {
                    navController.navigate(Screen.PrivacySecuritySettings.route)
                }
            ) {
                Row {
                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Privacy and security",
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_12sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp,
                            color = wheat.copy(0.66f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(DIMENS_20dp),
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "arrow_right",
                            tint = Ros
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DIMENS_20dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                RowPhotos()}
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                NeuButton(
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .height(60.dp),
                    lightColor = Ros,
                    onClick = {
                        navController.navigate(route = BottomNavItemScreen.Start.route)
                    }
                )
                {
                    Text(
                        text = "back",
                        color = MDark,
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_12sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp,
                        modifier = Modifier
                            .padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RowPhotos() {
    var isVisible by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
           .padding(start = DIMENS_32dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null)
            {
                isVisible = !isVisible
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
        ) {
        images.forEachIndexed { index, url ->
            ImageCard(
                imageUrl = url,
                index = index,
                isVisible = isVisible,
            )
        }
    }
}

@Composable
fun ImageCard(
    imageUrl: String, index: Int, isVisible: Boolean
) {
    var isVisibleTarget by remember { mutableStateOf(false) }
    LaunchedEffect(isVisible) {
        if (isVisible) {
            delay(index * 100L)
            isVisibleTarget = isVisible
        } else {
            isVisibleTarget = isVisible
        }
    }
    val transition = updateTransition(targetState = isVisibleTarget, label = "ImageAnimation")
    val transitionSpec: @Composable (Transition.Segment<Boolean>.() -> FiniteAnimationSpec<Float>) =
        remember {
            {
                when {
                    true isTransitioningTo false -> snap()
                    else -> spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                }
            }
        }
    val scale = transition.animateFloat(
        transitionSpec = transitionSpec,
        label = "Scale"
    ) { isVisible ->
        if (isVisible) 1f else 0f
    }
    val rotation = transition.animateFloat(
        transitionSpec = transitionSpec,
        label = "Rotation"
    ) { isVisible ->
        if (isVisible) rotationDegrees[index] else 0f
    }

    val modifier = Modifier
        .graphicsLayer {
            scaleX = scale.value
            scaleY = scale.value
            rotationZ = rotation.value
            translationX = -30f * index
        }
    PhotoSquare(imageUrl, modifier)
}

@Composable
private fun PhotoSquare(
    imageUrl: String,
    modifier: Modifier,
) {
    val shape = remember { RoundedCornerShape(8.dp) }
    Image(
        painter = rememberAsyncImagePainter(imageUrl, placeholder = ColorPainter(Color.Gray)),
        contentDescription = "Photos",
        modifier = modifier
            .size(64.dp)
            .shadow(elevation = 2.dp, shape)
            .border(width = 2.dp, color = wheat, shape = shape)
            .padding(0.dp),
        contentScale = ContentScale.Crop
    )
}
    private val images = listOf(
        "https://www.iwoio.com/wp-content/uploads/2024/01/1-20-scaled.jpg",
        "https://www.iwoio.com/wp-content/uploads/2023/10/cards11.jpg",
        "https://www.iwoio.com/wp-content/uploads/2023/12/venue_3_dark.jpg",
        "https://www.iwoio.com/wp-content/uploads/2023/10/card20-6.jpg",
    )
    private val rotationDegrees = listOf(10f, -20f, 5f, -15f, -2f)
    class ColorPainter(private val color: Color) : Painter() {
        override val intrinsicSize: Size
            get() = Size.Unspecified
    override fun DrawScope.onDraw() {
        drawRect(color = color)
    }
}
