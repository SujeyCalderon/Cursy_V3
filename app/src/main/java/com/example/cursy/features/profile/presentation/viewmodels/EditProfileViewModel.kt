package com.example.cursy.features.profile.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.cursy.features.course.domain.usecases.UploadImageUseCase
import com.example.cursy.features.profile.domain.usecases.UpdateProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val uploadImageUseCase: UploadImageUseCase
) : ViewModel() {

    suspend fun updateProfile(
        name: String?,
        profileImage: String?,
        bio: String?,
        university: String?
    ): Result<Unit> {
        return updateProfileUseCase(
            name = name,
            profileImage = profileImage,
            bio = bio,
            university = university
        )
    }

    suspend fun uploadImage(file: File): Result<String> {
        return uploadImageUseCase(file)
    }
}
