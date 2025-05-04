package se.android.blibb.presentation.screen.smarthome_two.search

import androidx.annotation.DrawableRes

data class SearchDevice(
    @DrawableRes val picture: Int,
    val title: String,
    val deviceType: String,
    var isSelected: Boolean = false
)