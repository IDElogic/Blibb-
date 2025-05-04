package se.android.blibb.presentation.screen.auth.navigation

sealed class AuthScreen(val route: String) {
    object Main : AuthScreen("auth_main")
    object Login : AuthScreen("auth_login")
    object Register : AuthScreen("auth_register")
}