package com.soupflies.keepr.ui.resetPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import com.soupflies.keepr_mpp.ui.presenters.ForgotPasswordPresenter
import com.soupflies.keepr_mpp.ui.viewModels.ForgotPasswordViewModel
import com.soupflies.keepr_mpp.ui.views.ForgotPasswordView
import kotlinx.android.synthetic.main.fragment_forgot_password.view.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ForgotPasswordFragment: Fragment(), ForgotPasswordView {

    private val job = Job()
    private val coroutineScope  = CoroutineScope(Dispatchers.Default + job)

    private val viewModel = ForgotPasswordViewModel
    private val presenter = ForgotPasswordPresenter(this, viewModel)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.send_code_button.setOnClickListener {
            presenter.sendForgotPasswordCode()

            // Simulate auto populating code from email/text
            coroutineScope.launch {
                delay(1500)

                withContext(Dispatchers.Main) {
                    view.reset_password_input.setText(presenter.generatedResetCode)
                }
            }
        }

        view.reset_password_button.setOnClickListener {
            presenter.checkPasswordCode(view.reset_password_input.text.toString())
        }
    }

    override fun navigateToLoginView() {
        findNavController().popBackStack()
    }

    override fun navigateToResetPasswordView() {
        findNavController().navigate(R.id.action_forgotPasswordFragment_to_resetPasswordFragment)
    }

    override fun alertUser(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }
}