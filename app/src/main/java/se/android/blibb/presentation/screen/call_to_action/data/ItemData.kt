package se.android.blibb.presentation.screen.call_to_action.data

import androidx.annotation.DrawableRes
import se.android.blibb.R

data class ItemState (
    val name: String,
    @DrawableRes
    val imgRes: Int)

val ItemData = listOf(
    ItemState(
        imgRes = R.drawable.shoes,
        name = "running shoes",
    ),
    ItemState(
        imgRes = R.drawable.shoes,
        name = "running shoes",
    )
)

