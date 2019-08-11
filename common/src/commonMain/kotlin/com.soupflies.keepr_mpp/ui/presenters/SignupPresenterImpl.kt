package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.serialized.User
import com.soupflies.keepr_mpp.ui.presenters.interfaces.SignupPresenter
import com.soupflies.keepr_mpp.ui.viewModels.SignupViewModel
import com.soupflies.keepr_mpp.ui.views.SignupView


class SignupPresenterImpl(val view: SignupView, val viewModel: SignupViewModel): SignupPresenter {

    override fun submitSignup(): Boolean {

        val validInput = view.validateInput()

        return if (validInput) {

            val newUser = User(
                userName = viewModel.username.value,
                email = viewModel.email.value,
                password = viewModel.password.value,
                useBiometrics = viewModel.useBiometrics.value
            )

            // Depending on results from saveUserData navigate to next screen
            saveUserData(newUser)
        } else false

    }

    override fun saveUserData(user: User): Boolean {

    }

}