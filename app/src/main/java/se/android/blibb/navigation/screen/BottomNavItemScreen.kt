package se.android.blibb.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItemScreen(val route: String, val icon: ImageVector, val title: String) {

    object Start : BottomNavItemScreen("start_screen", Icons.Default.Home, "Start")

    object Home : BottomNavItemScreen("home_screen", Icons.Default.ShoppingCart, "Store")

    object Cart : BottomNavItemScreen("cart_screen", Icons.Default.ShoppingCart, "Cart")

    object About : BottomNavItemScreen("about_screen", Icons.Default.Menu, "About")

    object Profile : BottomNavItemScreen("profile_screen", Icons.Default.Refresh, "Profile")

    object Explore : BottomNavItemScreen("explore_screen", Icons.Default.Person, "Explore")

    object SmartHomeScreen : BottomNavItemScreen("smart_home_two_screen", Icons.Default.SmartDisplay, "SmartHome")
}
