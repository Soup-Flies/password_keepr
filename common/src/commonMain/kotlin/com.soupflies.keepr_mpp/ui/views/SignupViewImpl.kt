package com.soupflies.keepr_mpp.ui.views

import com.soupflies.keepr_mpp.ui.viewModels.SignupViewModel

class SignupViewImpl: SignupView {

    val signupModel = SignupViewModel

    override fun validateInput(): Boolean {

        var isValid: Boolean = true

        with(signupModel) {

            usernameError.value = if (isInvalidInput(username.value, InputField.USERNAME)) {
                isValid = false
                InputField.USERNAME.errorMessage
            } else ""


            emailError.value = if (isInvalidInput(email.value, InputField.EMAIL)) {
                isValid = false
                InputField.EMAIL.errorMessage
            } else ""

            passwordError.value = if (isInvalidInput(password.value, InputField.PASSWORD)) {
                isValid = false
                InputField.PASSWORD.errorMessage
            } else ""

        }

        return isValid
    }

    private fun isInvalidInput(input: String, type: InputField): Boolean = type.checkPattern(input)

    enum class InputField: com.soupflies.keepr_mpp.ui.presenters.interfaces.InputField {

        USERNAME {
            override val pattern: Regex = Regex("^[\\S]{4,}$")
            override val errorMessage: String =
                "Please make sure your username is at least 4 characters"
        },

        EMAIL {
            // Over simplified email regex
            override val pattern: Regex = Regex("^[\\w.]+@[a-z]+\\.[a-z]{2,4}$")
            override val errorMessage: String = "Please double check your email for validity"
        },

        PASSWORD {
            override val pattern = Regex("^[a-z0-9.!@#\$%^&*]{8,}\$", options = setOf(RegexOption.IGNORE_CASE))
            override val errorMessage: String =
                "Please make sure your password contains atleast 8 characters, and only A-Z, 0-9, !@#\$%^&*"
        }
    }

}