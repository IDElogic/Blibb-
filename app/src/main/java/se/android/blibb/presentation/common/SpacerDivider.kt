package se.android.blibb.presentation.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import se.android.blibb.ui.theme.DIMENS_1dp
import se.android.blibb.ui.theme.DIMENS_24dp
import se.android.blibb.ui.theme.DIMENS_8dp

@Composable
fun SpacerDividerContent(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.height(DIMENS_8dp))

    Divider(modifier = modifier.height(DIMENS_1dp))

    Spacer(modifier = modifier.height(DIMENS_24dp))
}