package com.soupflies.keepr.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import com.soupflies.keepr_mpp.ui.presenters.SignupPresenter
import com.soupflies.keepr_mpp.ui.viewModels.SignupViewModel
import com.soupflies.keepr_mpp.ui.views.SignupView
import kotlinx.android.synthetic.main.fragment_signup.view.*

class SignupFragment: Fragment(), SignupView {
    val signupModel = SignupViewModel
    val signupPresenter = SignupPresenter(this, signupModel)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.submit_button.setOnClickListener {signupPresenter.submitSignup() }
    }

    override fun alertUser(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToPasswordVault() {
        findNavController().navigate(R.id.action_signupFragment_to_passwordVaultFragment)
    }

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

    companion object {
        fun newInstance() = SignupFragment()
    }
}