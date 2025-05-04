package se.android.blibb.presentation.screen.recipe

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import se.android.blibb.presentation.screen.recipe.details.RecipeDetails
import se.android.blibb.presentation.screen.recipe.model.recipesList
import se.android.blibb.presentation.screen.recipe.recipeslist.RecipesListScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RecipeUIScreen( isLarge: Boolean = false)
{
    val navController = rememberNavController()
        val items by remember { mutableStateOf(recipesList) }
        var currentRecipe = items.first()

        SharedTransitionLayout {
            val sharedTransitionScope = this
            NavHost(
                navController = navController,
                startDestination = RecipeAppScreen.List.name,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = RecipeAppScreen.List.name) {
                    RecipesListScreen(animatedVisibilityScope = this,
                        sharedTransactionScope = sharedTransitionScope,
                        isLarge = isLarge,
                        items = items,
                        onClick = { recipe ->
                            currentRecipe = recipe
                            navController.navigate(RecipeAppScreen.Details.name)
                        })
                }
                composable(route = RecipeAppScreen.Details.name) {
                    RecipeDetails(animatedVisibilityScope = this,
                        sharedTransactionScope = sharedTransitionScope,
                        recipe = currentRecipe,
                        goBack = { navController.popBackStack() })
                }
            }
        }
    }

enum class RecipeAppScreen {
    List, Details,
}