package com.soupflies.keepr_mpp.ui.viewModels.modelState

sealed class LoginViewState {
    object Biometric: LoginViewState()

    object Password: LoginViewState()
}