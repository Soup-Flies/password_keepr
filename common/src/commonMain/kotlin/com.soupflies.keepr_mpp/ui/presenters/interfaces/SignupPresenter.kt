package com.soupflies.keepr_mpp.ui.presenters.interfaces

import com.soupflies.keepr_mpp.serialized.User

interface SignupPresenter {

    val userRepository: UserRepository

    fun submitSignup(): Boolean

    fun saveUserData(user: User): Boolean
}