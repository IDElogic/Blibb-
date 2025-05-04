package se.android.blibb.presentation.screen.admin.allorders

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.wheat

@Composable
fun AllOrdersScreen (
    modifier: Modifier = Modifier
) {

    Column(
    modifier = modifier
    .padding(16.dp)
    .border(DIMENS_1dp, MDark.copy(0.2f))
    .background(wheat)
    ) {
       Text(
           text = "itt jelenik meg a lista")
    }
}