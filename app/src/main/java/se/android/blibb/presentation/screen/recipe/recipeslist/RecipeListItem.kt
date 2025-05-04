package se.android.blibb.presentation.screen.recipe.recipeslist

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.R
import se.android.blibb.presentation.screen.recipe.model.Recipe
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_4dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.Ros


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RecipeListItem(
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    recipe: Recipe,
    onClick: (recipe: Recipe) -> Unit,
) {
    Box(modifier = Modifier) {
        Box(modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp, bottom = 16.dp)
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp),
                clip = true,
                ambientColor = Ros,
                spotColor = Ros
            )
            .background(recipe.bgColor, RoundedCornerShape(20.dp))
            .fillMaxHeight().clickable {
                onClick(recipe)
            }) {
            with(sharedTransitionScope) {

                Card(
                    colors = CardDefaults.cardColors(recipe.bgColor),
                    shape = RoundedCornerShape(DIMENS_20dp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(DIMENS_20dp))
                        .sharedElement(state = rememberSharedContentState(
                            key = "item-container-${recipe.id}"),
                        animatedVisibilityScope = animatedVisibilityScope))
                {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.5f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(DIMENS_16dp)
                                .fillMaxWidth(0.55f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .align(Alignment.Top)
                            ) {
                                Text(
                                    text = recipe.title,
                                    style = LocalTextStyle.current.copy(
                                        color = MSecond,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.SemiBold
                                    ),
                                    modifier = Modifier.sharedElement(
                                        state = rememberSharedContentState(
                                            key = "item-title-${recipe.id}"
                                        ),
                                        animatedVisibilityScope = animatedVisibilityScope,
                                    )
                                )
                                Text(
                                    recipe.description,
                                    style = LocalTextStyle.current.copy(
                                        color = MSecond,
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Black,
                                        fontSize = 20.sp
                                    ),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(top = 8.dp).sharedElement(
                                        state = rememberSharedContentState(
                                            key = "recipe-description-${recipe.id}"
                                        ),
                                        animatedVisibilityScope = animatedVisibilityScope,
                                    )
                                )
                                Spacer(modifier = Modifier.height(DIMENS_16dp))
                                Image(
                                    colorFilter = ColorFilter.tint(MSecond),
                                    painter = painterResource(id = R.drawable.ic_favorite_border),
                                    contentDescription = "attached-file",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_16dp),
                                )
                                Spacer(modifier = Modifier.height(DIMENS_8dp))
                                Image(
                                    colorFilter = ColorFilter.tint(MSecond),
                                    painter = painterResource(id = R.drawable.ic_clock),
                                    contentDescription = "attached-file",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_16dp),
                                )
                                Spacer(modifier = Modifier.height(DIMENS_8dp))
                                Image(
                                    colorFilter = ColorFilter.tint(MSecond),
                                    painter = painterResource(id = R.drawable.baseline_attach_file_24),
                                    contentDescription = "attached-file",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .size(DIMENS_16dp),
                                )
                                Spacer(modifier = Modifier.height(DIMENS_8dp))
                                        Text(
                                            text = "Quick & Easy",
                                            style = LocalTextStyle.current.copy(
                                                color = Color(0xFF3F1642),
                                                fontFamily = GilroyFontFamily,
                                                fontWeight = FontWeight.SemiBold
                                            ),
                                            modifier = Modifier)

                            }
                            Spacer(modifier = Modifier.width(DIMENS_8dp))
                        }

                        RecipeListItemImageWrapper(
                            modifier = Modifier
                                .padding(DIMENS_4dp)
                                .align(Alignment.BottomEnd)
                                .fillMaxWidth(0.45f)
                                .aspectRatio(1f),
                            child = {
                                RecipeImage(
                                    imageBitmap = recipe.image,
                                    modifier = Modifier
                                        .sharedElement(
                                            state = rememberSharedContentState(key = "item-image-${recipe.id}"),
                                            animatedVisibilityScope = animatedVisibilityScope
                                        )
                                )
                            })
                    }
                }
            }
        }
    }
}
