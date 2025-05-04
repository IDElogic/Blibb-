package se.android.blibb.presentation.screen.ui_examples.lightswitch.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import se.android.blibb.presentation.component.NeuButton
import se.android.blibb.ui.theme.DIMENS_16dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.MDark

@Composable
fun ColorItem(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit)
{
    NeuButton(
        shape = RoundedCornerShape(DIMENS_16dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(
                start = DIMENS_2dp,
                end = DIMENS_1dp
            )
            .border(
                1.dp,
                color,
                RoundedCornerShape(DIMENS_16dp)
            ),
        lightColor = color,
        onClick = {
            onClick()
        }
    ) {
        Icon(modifier = Modifier
            .size(DIMENS_20dp),
            imageVector = Icons.Default.Refresh,
            contentDescription = "light",
            tint = MDark.copy(0.66f)
        )
    }
}
    val COLOR_LIST = listOf(
        Color(0xFFe6e8fa),
        Color(0xFFC4BEA2),
        Color(0xFFB68D82)
    )


