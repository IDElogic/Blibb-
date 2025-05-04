package se.android.blibb.presentation.screen.auth.registration

import se.android.blibb.presentation.screen.auth.data.User

sealed class RegistrationState {
    object Idle : RegistrationState()
    data class Registering(val user: User) : RegistrationState()
    object Success : RegistrationState()
    data class Error(val message: String) : RegistrationState()
}