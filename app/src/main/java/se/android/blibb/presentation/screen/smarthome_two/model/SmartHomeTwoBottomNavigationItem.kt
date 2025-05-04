package se.android.blibb.presentation.screen.smarthome_two.model

import androidx.annotation.DrawableRes

data class SmartHomeTwoBottomNavigationItem(
    val route: String,
    val title: String,
    @DrawableRes val selectedIcon: Int,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)