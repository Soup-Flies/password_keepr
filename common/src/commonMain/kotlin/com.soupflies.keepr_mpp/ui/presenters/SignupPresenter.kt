package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.repositories.UserRepository
import com.soupflies.keepr_mpp.serialized.User
import com.soupflies.keepr_mpp.ui.viewModels.SignupViewModel
import com.soupflies.keepr_mpp.ui.views.SignupView


class SignupPresenter(val view: SignupView, private val viewModel: SignupViewModel) {

    private val userRepo = UserRepository()

    fun submitSignup() {

        val validInput = view.validateInput()

        if (validInput) {
            val newUser = User(
                userName = viewModel.username.value,
                email = viewModel.email.value,
                password = viewModel.password.value,
                useBiometrics = viewModel.useBiometrics.value
            )

            val userCreated = userRepo.saveUser(newUser)

            if (userCreated) view.navigateToPasswordVault()
            else view.alertUser("Error Creating new account -- please try again")
        }
    }
}