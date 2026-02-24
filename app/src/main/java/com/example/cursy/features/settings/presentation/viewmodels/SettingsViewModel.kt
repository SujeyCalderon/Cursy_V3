package com.example.cursy.features.settings.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cursy.core.di.AuthManager
import com.example.cursy.core.network.CoursyApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val authManager: AuthManager,
    private val coursyApi: CoursyApi
) : ViewModel() {

    private val _navigateToLogin = MutableStateFlow(false)
    val navigateToLogin = _navigateToLogin.asStateFlow()

    fun logout() {
        authManager.clear()
        _navigateToLogin.value = true
    }

    fun deleteAccount() {
        viewModelScope.launch {
            try {
                coursyApi.deleteAccount()
                authManager.clear()
                _navigateToLogin.value = true
            } catch (e: Exception) {
                Log.e("Settings", "Error al eliminar cuenta: ${e.message}")
            }
        }
    }

    fun resetNavigation() {
        _navigateToLogin.value = false
    }
}
