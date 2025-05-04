package se.android.blibb.presentation.screen.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import se.android.blibb.navigation.graph.Graph
import se.android.blibb.navigation.screen.BottomNavItemScreen
import se.android.blibb.presentation.screen.auth.AuthMainScreen
import se.android.blibb.presentation.screen.auth.login.LoginScreen
import se.android.blibb.presentation.screen.auth.registration.RegistrationScreen
import se.android.blibb.presentation.screen.auth.registration.UserViewModel

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    userViewModel: UserViewModel
) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Main.route
    ) {
        composable(route = AuthScreen.Main.route) {
            AuthMainScreen(
                userViewModel = userViewModel,
                navController = navController)
        }

       composable(route = AuthScreen.Login.route) {
            LoginScreen(
                userViewModel = userViewModel,
                onRegisterClick = {
                    navController.navigate(AuthScreen.Register.route)
                                  },
                onLoginSuccess = { isAdmin ->
                    if (isAdmin) {
                        navController.navigate(Graph.ADMIN) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    } else {
                        navController.navigate(Graph.MAIN) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    }
                }
            )
        }


        }
        composable(route = AuthScreen.Register.route) {
            RegistrationScreen(
                onRegisterClick = { user ->
                    // Implement registration logic
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }
    }
