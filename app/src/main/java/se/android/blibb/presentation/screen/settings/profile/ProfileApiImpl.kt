package se.android.blibb.presentation.screen.settings.profile

import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProfileApiImpl : ProfileApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://your-api-base-url.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(ProfileApi::class.java)

    override suspend fun updateProfile(
        username: String,
        email: String,
        phone: String,
        bio: String,
        profileImage: MultipartBody.Part?
    ): ProfileUpdateResponse {
        return api.updateProfile(username, email, phone, bio, profileImage)
    }
}