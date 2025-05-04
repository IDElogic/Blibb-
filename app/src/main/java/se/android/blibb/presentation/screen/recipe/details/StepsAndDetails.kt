package se.android.blibb.presentation.screen.recipe.details

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import se.android.blibb.presentation.screen.recipe.model.Recipe
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_16sp

@OptIn(ExperimentalSharedTransitionApi::class)
internal fun LazyListScope.StepsAndDetails(
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransactionScope: SharedTransitionScope,
    recipe: Recipe
) {
    with(sharedTransactionScope) {
        item {

            Text(
                text = recipe.title,
                style = LocalTextStyle.current.copy(
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp).then(
                    Modifier.sharedElement(
                        rememberSharedContentState(
                            key = "recipe-title-${recipe.id}"
                        ),
                        animatedVisibilityScope,)))
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp).then(
                    Modifier.sharedElement(
                        rememberSharedContentState(
                            key = "recipe-description-${recipe.id}"
                        ),
                        animatedVisibilityScope,
                    )
                )
            )

            AnimateInEffect(
                recipe = recipe,
                intervalStart = 0 / (recipe.instructions.size + recipe.ingredients.size + 2).toFloat(),
                content = {
                    Text(
                        text = "INGREDIENTS",
                        style = LocalTextStyle.current.copy(
                            color = MDark,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = TEXT_SIZE_16sp
                        ),
                        modifier = Modifier
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    )
                })
        }

        itemsIndexed(recipe.ingredients) { index, value ->
            AnimateInEffect(
                intervalStart = (index + 1) / (recipe.instructions.size + recipe.ingredients.size + 1).toFloat(),
                recipe = recipe,
                content = {
                    IngredientItem(recipe, value)
                }
            )
        }

        item {
            AnimateInEffect(
                recipe = recipe,
                intervalStart = (recipe.ingredients.size + 1) / (recipe.instructions.size + recipe.ingredients.size + 2).toFloat(),
                content = {
                    Text(
                        text = "STEPS",
                        style = LocalTextStyle.current.copy(
                            color = MDark,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = TEXT_SIZE_16sp),
                        modifier = Modifier
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    )
                }
            )
        }

        itemsIndexed(recipe.instructions) { index, _ ->
            AnimateInEffect(
                recipe = recipe,
                intervalStart = (recipe.ingredients.size + index + 1) / (recipe.instructions.size + recipe.ingredients.size + 1).toFloat(),
                content = {
                    InstructionItem(recipe, index)
                })
        }
    }
}