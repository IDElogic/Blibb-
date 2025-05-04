package se.android.blibb.presentation.screen.call_to_action.data

import androidx.annotation.DrawableRes
import se.android.blibb.R

data class PreviewState(
    val headline: String = "Best For 2025",
    @DrawableRes
    val productImg: Int = R.drawable.running_man,
)