package se.android.blibb.presentation.screen.smarthome_two.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import se.android.blibb.presentation.screen.smarthome_two.home.SmartHomeScreen
import se.android.blibb.presentation.screen.smarthome_two.search.SearchDeviceList

@Composable
fun SmartHomeTwoNavigation(
     navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "smart_home_screen"
    ) {

        composable(route = "smart_home_screen") {
            SmartHomeScreen(navController = navController)
        }

        composable(route = "search") {
            SearchDeviceList(navController = navController)
        }
    }
}