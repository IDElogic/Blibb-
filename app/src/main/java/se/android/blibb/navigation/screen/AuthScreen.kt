package se.android.blibb.navigation.screen

sealed class AuthScreen(val route: String) {
    object Main : AuthScreen("auth_main")
    object Login : AuthScreen("auth_login")
    object Register : AuthScreen("auth_register")
}