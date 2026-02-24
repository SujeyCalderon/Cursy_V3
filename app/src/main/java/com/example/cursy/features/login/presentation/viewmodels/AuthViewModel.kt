package com.example.cursy.features.login.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.cursy.core.di.AuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authManager: AuthManager
) : ViewModel() {

    fun setAuthToken(token: String) {
        authManager.setAuthToken(token)
    }

    fun setCurrentUserId(userId: String) {
        authManager.setCurrentUserId(userId)
    }
}
