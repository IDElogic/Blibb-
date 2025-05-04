package se.android.blibb.presentation.screen.recipe.recipeslist

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.R
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.presentation.screen.recipe.model.Recipe
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_24dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RecipesListScreen(
    items: List<Recipe>,
    onClick: (recipe: Recipe) -> Unit,
    isLarge: Boolean,
    sharedTransactionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.horizontalGradient(
                listOf(
                    MSecond,
                    MSecond.copy(alpha = 0.66f)
                )))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding( DIMENS_10dp)
        ) {
            Spacer(modifier = Modifier.height(DIMENS_20dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(DIMENS_32dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Recipes",
                    style = LocalTextStyle.current.copy(
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 32.sp
                    )
                )
                Spacer(modifier = Modifier.width(DIMENS_20dp))
                Image(
                    colorFilter = ColorFilter.tint(wheat),
                    painter = painterResource(id = R.drawable.btn_2),
                    contentDescription = "attached-file",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(0.dp)
                        .size(DIMENS_24dp),
                )
                Spacer(modifier = Modifier.width(DIMENS_20dp))
                Image(
                    colorFilter = ColorFilter.tint(wheat),
                    painter = painterResource(id = R.drawable.btn_2),
                    contentDescription = "attached-file",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(0.dp)
                        .size(DIMENS_24dp),
                )
                Spacer(modifier = Modifier.width(DIMENS_20dp))
                Image(
                    colorFilter = ColorFilter.tint(wheat),
                    painter = painterResource(id = R.drawable.btn_2),
                    contentDescription = "attached-file",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(0.dp)
                        .size(DIMENS_24dp),
                )
                Spacer(modifier = Modifier.width(DIMENS_20dp))
                Image(
                    colorFilter = ColorFilter.tint(wheat),
                    painter = painterResource(id = R.drawable.btn_2),
                    contentDescription = "attached-file",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(0.dp)
                        .size(DIMENS_24dp),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center)
            {
                NeuButton(
                    shape = RoundedCornerShape(90.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(bottom = 5.dp, end = DIMENS_20dp, start = DIMENS_20dp)
                        .border(1.dp, Ros, RoundedCornerShape(90.dp)),
                    lightColor = Ros,
                    onClick = {
                       // navController.navigate("upload_screen")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Add Recipe",
                            color = MDark,
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_12sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                        Icon(
                            modifier = Modifier
                                .size(DIMENS_16dp),
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "arrow_right",
                            tint = MDark
                        )
                    }
                }
            }

        Spacer(modifier = Modifier.height(DIMENS_20dp))
        val listState = rememberLazyGridState()
        LazyVerticalGrid(
            state = listState, columns = GridCells.Fixed(if (isLarge) 3 else 1)
        ) {
            items(items.size) { item ->
                val recipe = items[item]
                RecipeListItemWrapper(
                    scrollDirection = listState.isScrollingUp(),
                    child = {
                        RecipeListItem(
                            recipe = recipe,
                            onClick = onClick,
                            sharedTransitionScope = sharedTransactionScope,
                            animatedVisibilityScope = animatedVisibilityScope,
                        )
                    }
                )
            }
        }
        }
    }
}

@Composable
private fun LazyGridState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}