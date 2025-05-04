package se.android.blibb.presentation.screen.call_to_action.newsletter

import androidx.compose.runtime.Stable

@Stable
data class NewsletterUiState(
    val email: String = "",
    val isEmailValid: Boolean = false,
    val isLoading: Boolean = false,
    val isSubscribed: Boolean = false,
    val error: String? = null
)