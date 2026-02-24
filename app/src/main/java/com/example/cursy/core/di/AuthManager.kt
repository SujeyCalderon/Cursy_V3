package com.example.cursy.core.di

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthManager @Inject constructor() {
    private var authToken: String? = null
    private var currentUserId: String? = null

    fun setAuthToken(token: String) {
        authToken = token
    }

    fun getAuthToken(): String? = authToken

    fun setCurrentUserId(userId: String) {
        currentUserId = userId
    }

    fun getCurrentUserId(): String? = currentUserId

    fun clear() {
        authToken = null
        currentUserId = null
    }
}
