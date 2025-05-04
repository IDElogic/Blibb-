package se.android.blibb.presentation.screen.settings.profile

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ProfileSettingsViewModel(private val api: ProfileApi) : ViewModel() {
    private val _updateResult = MutableStateFlow<Result<Boolean>?>(null)
    val updateResult: StateFlow<Result<Boolean>?> = _updateResult

        fun saveProfile(
        username: String,
        email: String,
        phoneNumber: String,
        bio: String,
        profileImageUri: Uri?
    ) {
        viewModelScope.launch {
            try {
                val imageFile = profileImageUri?.let { uri ->
                    val file = File(uri.path)
                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    MultipartBody.Part.createFormData("profile_image", file.name, requestFile)
                }

                val response = api.updateProfile(username, email, phoneNumber, bio, imageFile)
                _updateResult.value = Result.success(true)
            } catch (e: Exception) {
                _updateResult.value = Result.failure(e)
            }
        }
    }


    private val _userData = MutableStateFlow(UserData())
    val userData: StateFlow<UserData> = _userData

    fun updateUserData(newData: UserData) {
        _userData.value = newData
    }

    data class UserData(
        val username: String = "",
        val email: String = "",
        val phoneNumber: String = "",
        val bio: String =""
    )
}