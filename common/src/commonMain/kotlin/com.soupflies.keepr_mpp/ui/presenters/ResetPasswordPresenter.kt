package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.repositories.UserRepository
import com.soupflies.keepr_mpp.ui.viewModels.ResetPasswordViewModel
import com.soupflies.keepr_mpp.ui.views.ResetPasswordView

class ResetPasswordPresenter(val view: ResetPasswordView, val viewModel: ResetPasswordViewModel) {

    val userRepo = UserRepository()

    fun updateUserPassword() {

        if (view.confirmPasswordsSame()) {
            val userResponse = userRepo.getCurrentUser()

            if (userResponse != null) {

                val newUser = userResponse.copy( password = view.currentPasswordValue() )

                userRepo.updateUser(newUser)

                view.alertUser("Password update success, please log in")

                view.navigateToLoginView()

            } else {
                view.alertUser("No local stored user -- Please make an account first")
                view.navigateToSignupView()
            }
        }
    }
}