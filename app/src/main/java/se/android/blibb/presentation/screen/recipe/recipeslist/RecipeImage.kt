package se.android.blibb.presentation.screen.recipe.recipeslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import se.android.blibb.ui.theme.Ros

@Composable
fun RecipeImage(imageBitmap: Int, modifier: Modifier) {
    Box(modifier = Modifier) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(50)
                )
        )
        Image(
            painter = painterResource(imageBitmap),
            contentDescription = null,
            modifier = modifier.background(
                color = Ros.copy(alpha = 0.2f),
                shape = CircleShape,
            ).aspectRatio(1f)
        )
    }
}
