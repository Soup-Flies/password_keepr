package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.repositories.UserRepository
import com.soupflies.keepr_mpp.ui.viewModels.LoginViewModel
import com.soupflies.keepr_mpp.ui.viewModels.modelState.LoginViewState
import com.soupflies.keepr_mpp.ui.views.LoginView

class LoginPresenter(val view: LoginView, val viewModel: LoginViewModel) {

    val userRepo = UserRepository()

    init {
        if (view.isBiometricCapable()) updateUiState(LoginViewState.Biometric)
        else updateUiState(LoginViewState.Password)
    }

    fun acceptBiometricLogin() {
        // Verification of safe?
        view.navigateToPasswordVault()
    }

    fun updateUiState(state: LoginViewState) { viewModel.currentState.value = state }

    fun attemptPasswordLogin(password: String) {
        val userResponse = userRepo.logUserIn(password)

        if (userResponse != null) view.navigateToPasswordVault()
        else view.alertUser("Error attempting login, please double check password and try again")
    }

    fun setUserForgotPassword() { view.navigateToForgotPassword() }
}