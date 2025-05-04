package se.android.blibb.presentation.screen.auth.login

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val isAdmin: Boolean) : LoginState()
    data class Error(val message: String) : LoginState()
}