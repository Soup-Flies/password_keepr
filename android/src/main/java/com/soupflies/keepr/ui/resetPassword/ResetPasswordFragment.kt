package com.soupflies.keepr.ui.resetPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import com.soupflies.keepr_mpp.ui.presenters.ResetPasswordPresenter
import com.soupflies.keepr_mpp.ui.viewModels.ResetPasswordViewModel
import com.soupflies.keepr_mpp.ui.views.ResetPasswordView
import kotlinx.android.synthetic.main.fragment_reset_password.view.*

class ResetPasswordFragment : Fragment(), ResetPasswordView {

    private val viewModel = ResetPasswordViewModel

    private val presenter = ResetPasswordPresenter(this, viewModel)

    private lateinit var newPassword: String
    private lateinit var confirmPassword: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reset_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newPassword = view.new_password_input.text.toString()
        confirmPassword = view.confirm_password_input.text.toString()

        view.submit_button.setOnClickListener { presenter.updateUserPassword() }
    }

    override fun navigateToLoginView() {
        findNavController().navigate(R.id.action_resetPasswordFragment_to_loginFragment)
    }

    override fun navigateToSignupView() {
        findNavController().navigate(R.id.action_resetPasswordFragment_to_signupFragment)
    }

    override fun alertUser(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun confirmPasswordsSame(): Boolean = newPassword == confirmPassword

    override fun currentPasswordValue(): String = newPassword


    companion object {
        fun newInstance() = ResetPasswordFragment()
    }
}