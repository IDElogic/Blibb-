package se.android.blibb.presentation.screen.recipe.model

import androidx.compose.ui.graphics.Color

data class Recipe (
    val id: Int,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val image: Int,
    val bgImage: Int? = null,
    val bgImageLarge: Int? = null,
    val bgColor: Color
)

