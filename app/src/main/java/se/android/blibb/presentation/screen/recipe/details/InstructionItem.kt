package se.android.blibb.presentation.screen.recipe.details

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import se.android.blibb.presentation.screen.recipe.model.Recipe
import se.android.blibb.ui.theme.DIMENS_48dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.MSecond
import se.android.blibb.ui.theme.TEXT_SIZE_16sp

@Composable
fun InstructionItem(recipe: Recipe, index: Int) {
    Box(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 0.5.dp, color = recipe.bgColor, shape = RoundedCornerShape(DIMENS_8dp))
                .clip(RoundedCornerShape(DIMENS_8dp))
        ) {
            Text(
                text = recipe.instructions[index],
                style = LocalTextStyle.current.copy(
                    color = MDark,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = TEXT_SIZE_16sp
                ),
                modifier = Modifier
                    .fillMaxWidth().fillMaxHeight()
                    .padding(start = 70.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
            )
        }

        Box(
            modifier = Modifier
                .padding(DIMENS_8dp)
        ) {
            Box(
                modifier = Modifier
                    .size(DIMENS_48dp)
                    .shadow(elevation = 10.dp, shape = CircleShape)
                    .background(
                        recipe.bgColor,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${index + 1}",
                    style = LocalTextStyle.current.copy(
                        color = MSecond,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = TEXT_SIZE_16sp
                    ),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(5.dp),
                    maxLines = 1,
                )
            }
        }
    }
}
