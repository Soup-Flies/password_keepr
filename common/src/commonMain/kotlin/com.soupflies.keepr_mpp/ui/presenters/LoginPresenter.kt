package com.soupflies.keepr_mpp.ui.presenters

class LoginPresenter(view: BaseView, viewModel: ViewModel): BasePresenter(view, viewModel) {

    fun checkBiometricCapable() {

        // Check if device is biometric capable <-- requires platform implementations

        // If so ->
        // Set ui state to reflect biometric enabled
        // Prompt user to use biometrics to log in
        handleBiometricLogin()

        // If not ->
        // Set ui state to reflect password enabled
        // Prompt user to input password
    }

    fun handleBiometricLogin() {}

    fun handlePasswordLogin() {}

    fun setUserForgotPassword() {

        // Update viewModel ui for Forgot password state
    }

    fun sendForgotPasswordCode() {

        // Get current user info from local storage solution

        // Show user ****'d email version

        // Send to user email random code

        // Expect code in device

        // Once entered properly, automatically move forward to password reset screen
    }



}