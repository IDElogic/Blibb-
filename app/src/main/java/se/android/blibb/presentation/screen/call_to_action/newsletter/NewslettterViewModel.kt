package se.android.blibb.presentation.screen.call_to_action.newsletter

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class NewsletterViewModel @Inject constructor(
    private val api: NewsletterApi
) : ViewModel() {
    private val _uiState = MutableStateFlow(NewsletterUiState())
    val uiState: StateFlow<NewsletterUiState> = _uiState.asStateFlow()


    fun onEmailChange(newEmail: String) {
        _uiState.update {
            it.copy(
                email = newEmail,
                isEmailValid = newEmail.isValidEmail()
            )
        }
    }

    fun subscribe() {
        if (!_uiState.value.isEmailValid) return

        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                api.subscribe(SubscriptionRequest(_uiState.value.email))
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSubscribed = true,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = when (e) {
                            is SocketTimeoutException -> "Timeout"
                            is UnknownHostException -> "No internet connection"
                            else -> "Server error: ${e.message ?: "Unknown error"}"
                        }
                    )
                }
            }
        }
    }

    fun String.isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this).matches() &&
                this.length <= 254 &&  // RFC 5321 limit
                this.count { it == '@' } == 1
    }
}






