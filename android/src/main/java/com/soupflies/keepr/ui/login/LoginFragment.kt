package com.soupflies.keepr.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import com.soupflies.keepr_mpp.ui.presenters.LoginPresenter
import com.soupflies.keepr_mpp.ui.viewModels.LoginViewModel
import com.soupflies.keepr_mpp.ui.viewModels.modelState.LoginViewState
import com.soupflies.keepr_mpp.ui.views.LoginView
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment: Fragment(), LoginView {
    val loginModel = LoginViewModel
    val loginPresenter = LoginPresenter(this, loginModel)

    var uiState: LoginViewState = loginModel.currentState.value

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginModel.currentState.addObserver(R.id.login_ui_state) { old, new -> uiState = new }

        //Temporary until biometrics implemented
        view.fingerprint_image.setOnClickListener { loginPresenter.acceptBiometricLogin() }

        view.use_password.setOnClickListener { loginPresenter.setUserForgotPassword() }
    }

    override fun isBiometricCapable(): Boolean {
        TODO("not implemented")
    }

    override fun navigateToForgotPassword() {
        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
    }

    override fun navigateToPasswordVault() {
        findNavController().navigate(R.id.action_loginFragment_to_passwordVaultFragment)
    }

    override fun alertUser(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}