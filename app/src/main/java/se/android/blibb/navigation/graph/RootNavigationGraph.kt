package se.android.blibb.navigation.graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.navigation.screen.Screen
import se.android.blibb.presentation.screen.MainScreen
import se.android.blibb.presentation.screen.admin.AdminDashboard
import se.android.blibb.presentation.screen.auth.navigation.authNavGraph
import se.android.blibb.presentation.screen.auth.registration.UserViewModel
import se.android.blibb.presentation.screen.onboarding.OnBoardingScreen
import se.android.blibb.presentation.screen.splash.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    val userViewModel: UserViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }

        composable(route = Graph.ADMIN) {
            AdminDashboard(
                userViewModel = UserViewModel(),
                navController = navController
            )
        }

        authNavGraph(navController, userViewModel)

        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}