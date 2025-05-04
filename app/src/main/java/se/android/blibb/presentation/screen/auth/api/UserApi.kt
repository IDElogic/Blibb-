package se.android.blibb.presentation.screen.auth.api

import retrofit2.http.Body
import retrofit2.http.POST
import se.android.blibb.presentation.screen.auth.data.User

interface UserApi {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): User

    @POST("register")
    suspend fun register(@Body user: User): User
}

data class LoginRequest(val email: String, val password: String)