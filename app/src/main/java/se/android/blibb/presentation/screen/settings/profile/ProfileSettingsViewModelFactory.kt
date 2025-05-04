package se.android.blibb.presentation.screen.settings.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProfileSettingsViewModelFactory(private val api: ProfileApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileSettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileSettingsViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}