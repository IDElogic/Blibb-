package se.android.blibb.presentation.screen.settings.profile

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ProfileApi {
    @Multipart
    @POST("update_profile")
    suspend fun updateProfile(
        @Part("username") username: String,
        @Part("email") email: String,
        @Part("phone") phone: String,
        @Part("bio") bio: String,
        @Part profileImage: MultipartBody.Part?
    ): ProfileUpdateResponse
}

data class ProfileUpdateResponse(
    val success: Boolean,
    val message: String
)


