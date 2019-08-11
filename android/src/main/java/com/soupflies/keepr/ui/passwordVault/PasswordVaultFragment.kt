package com.soupflies.keepr.ui.passwordVault

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soupflies.keepr.R

class PasswordVaultFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_password_vault, container, false)
    }

    companion object {
        fun newInstance() = PasswordVaultFragment()
    }
}