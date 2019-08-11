package com.soupflies.keepr.ui.resetPassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import kotlinx.android.synthetic.main.fragment_reset_password.view.*

class ResetPasswordFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reset_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.reset_password_button.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    companion object {
        fun newInstance() = ResetPasswordFragment()
    }
}