package se.android.blibb.presentation.screen.auth.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import se.android.blibb.presentation.screen.auth.data.User
import se.android.blibb.presentation.screen.auth.login.LoginState

class UserViewModel : ViewModel() {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val user = authenticateUser(email, password)
                if (user != null) {
                    _currentUser.value = user
                    _loginState.value = LoginState.Success(user.isAdmin)
                } else {
                    _loginState.value = LoginState.Error("Hibás email vagy jelszó")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Bejelentkezési hiba: ${e.message}")
            }
        }
    }

    private suspend fun authenticateUser(email: String, password: String): User? {
        return when {
            email == "admin@example.com" && password == "adminpass" ->
                User(
                    id = "1",
                    email = email,
                    password = password,  // Megjegyzés: általában nem ajánlott a jelszót tárolni
                    firstname = "Admin",
                    lastname = "User",
                    phone = "+123456789",
                    gdprConsent = "accepted",
                    isAdmin = true
                )
            email == "user@example.com" && password == "userpass" ->
                User(
                    id = "2",
                    email = email,
                    password = password,  // Megjegyzés: általában nem ajánlott a jelszót tárolni
                    firstname = "Normal",
                    lastname = "User",
                    phone = "+987654321",
                    gdprConsent = "accepted",
                    isAdmin = false
                )
            else -> null
        }
    }


    suspend fun register(user: User): Result<Unit> {
        return try {
            // Itt implementálja a tényleges regisztrációs logikát
            // Például: egy API hívás a szerverhez

            // Szimuláljuk a sikeres regisztrációt
            delay(1000) // Szimuláljuk a hálózati késleltetést

            // Ha a regisztráció sikeres, visszatérünk egy sikeres Result-tal
            Result.success(Unit)
        } catch (e: Exception) {
            // Ha bármilyen hiba történik, visszatérünk egy sikertelen Result-tal
            Result.failure(e)
        }
    }

    fun getAllUsers(): List<User> {
        // Implement logic to fetch all users from the server
        return emptyList() // Placeholder
    }

    fun logout() {
        viewModelScope.launch {
            _currentUser.value = null
            _loginState.value = LoginState.Idle
        }
    }
}


