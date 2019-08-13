package com.soupflies.keepr_mpp.ui.views

interface ResetPasswordView {

    fun navigateToLoginView()

    fun navigateToSignupView()

    fun alertUser(message: String)

    fun confirmPasswordsSame(): Boolean

    fun currentPasswordValue(): String
}