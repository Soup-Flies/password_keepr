package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.repositories.UserRepository
import com.soupflies.keepr_mpp.tooling.Logger
import com.soupflies.keepr_mpp.ui.viewModels.ForgotPasswordViewModel
import com.soupflies.keepr_mpp.ui.views.ForgotPasswordView
import kotlin.random.Random

class ForgotPasswordPresenter (val view: ForgotPasswordView, val viewModel: ForgotPasswordViewModel) {

    val userRepo = UserRepository()

    var generatedResetCode: String = Random.toString()

    fun sendForgotPasswordCode() {

        // Get current user info from local storage solution
        val user = userRepo.getCurrentUser()

        if (user != null) {
            // Show user email to expect response at
            viewModel.email.value = user.email

            // Send to user email generated code
            generatedResetCode = userRepo.sendUserGeneratedCode()
            Logger.d("FORGOT PASSWORD CODE:", "Code: $generatedResetCode")

            view.alertUser("For Testing purposes reset code is: $generatedResetCode")
        }
    }

    // Might not be needed, but adds consistency to work flow
    fun navigateToLoginView() = view.navigateToLoginView()


    fun checkPasswordCode(code: String) {
        // No actual API currently, return if code is longer than 4 characters for example
        if (code.length >= 4) view.navigateToResetPasswordView()
        else view.alertUser("Improper code, please double check input")
    }
}