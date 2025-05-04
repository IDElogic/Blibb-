package se.android.blibb.presentation.screen.auth.data

data class User(
    val id: String,
    val email: String,
    val password: String,
    val firstname: String,
    val lastname: String,
    val phone: String,
    val gdprConsent: String,
    val isAdmin: Boolean = false
)