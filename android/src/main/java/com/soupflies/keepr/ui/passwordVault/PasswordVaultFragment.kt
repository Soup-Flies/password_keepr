package com.soupflies.keepr.ui.passwordVault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavAction
import androidx.navigation.NavActionBuilder
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.ui.views.PasswordVaultView
import kotlinx.android.synthetic.main.fragment_password_vault.view.*

class PasswordVaultFragment: Fragment(), PasswordVaultView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_password_vault, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.add_new_password_button.setOnClickListener {
            findNavController().navigate(R.id.action_passwordVaultFragment_to_addNewPassword)
        }
    }

    override fun navigateToAccount(account: Account) {
        with(account) {
            val bundle = bundleOf(
                "title" to title,
                "username" to username,
                "email" to email,
                "password" to password,
                "website" to website,
                "notes" to notes
            )

            findNavController().navigate(R.id.action_passwordVaultFragment_to_addNewPassword, bundle)
        }
    }

    override fun navigateToCreateAccount() {
        findNavController().navigate(R.id.action_passwordVaultFragment_to_signupFragment)
    }

    companion object {
        fun newInstance() = PasswordVaultFragment()
    }
}