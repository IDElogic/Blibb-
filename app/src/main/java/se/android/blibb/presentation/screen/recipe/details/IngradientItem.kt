package se.android.blibb.presentation.screen.recipe.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import se.android.blibb.R
import se.android.blibb.presentation.screen.recipe.model.Recipe
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_64dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.wheat

@Composable
fun IngredientItem(recipe: Recipe, ingredient: String) {
    Box(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp, top = 8.dp))
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(wheat)
                .padding(vertical = DIMENS_10dp)
                .border(
                    width = 1.dp,
                    color = recipe.bgColor,
                    shape = RoundedCornerShape(DIMENS_8dp)
                )
        ) {
            Text(
                text = ingredient,
                style = LocalTextStyle.current.copy(
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = TEXT_SIZE_16sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DIMENS_64dp, end = DIMENS_8dp, top = DIMENS_20dp, bottom = DIMENS_20dp),
                maxLines = 1,
            )
        }

        Box(
            modifier = Modifier
                .padding(start = DIMENS_8dp)
        ) {
            Box(
                modifier = Modifier
                    .size(DIMENS_48dp)
                    .shadow(elevation = 10.dp, shape = CircleShape)
                    .background(
                        recipe.bgColor,
                        CircleShape))
            {
                Image(
                    painter = painterResource(R.drawable.btn_2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(DIMENS_8dp)
                        .rotate(-30f),
                    colorFilter = ColorFilter.tint(wheat)
                )
            }
        }
    }
}
