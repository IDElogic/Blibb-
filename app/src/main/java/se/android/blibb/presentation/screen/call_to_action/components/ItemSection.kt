package se.android.blibb.presentation.screen.call_to_action.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import se.android.blibb.presentation.screen.call_to_action.data.ItemState
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_140dp
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_8dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat

@Composable
fun ItemSection(
    modifier: Modifier = Modifier,
    data:List<ItemState>
) {
    Column(modifier = modifier)
    {
        SectionHeader(title = "super easy")
        Column {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = DIMENS_16dp),
                horizontalArrangement = Arrangement.spacedBy(DIMENS_16dp)
            ) {
                data.onEach {item ->
                    Item(
                        state = item,
                        modifier = Modifier
                            .weight(weight = 1f)
                    )
                }
            }
        }
    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String,
) {
    Row(
        modifier = modifier
            .padding(start = DIMENS_20dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = title,
            fontSize = TEXT_SIZE_16sp,
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Medium,
            letterSpacing = TEXT_SIZE_1sp,
            color = MDark
        )
    }
}

@Composable
private fun Item(
    modifier: Modifier = Modifier,
    state: ItemState
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = DIMENS_20dp)
            .background(wheat)
            .border(DIMENS_1dp,wheat, RoundedCornerShape(DIMENS_8dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(DIMENS_140dp)
                .padding(vertical = DIMENS_10dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = DIMENS_10dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.name,
                    color = MDark,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TEXT_SIZE_10sp,
                    fontFamily = GilroyFontFamily
                )
                Spacer(
                    modifier = Modifier
                        .height(DIMENS_8dp)
                )
                Image(painter = painterResource(id = state.imgRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth())
            }
        }
    }
}

