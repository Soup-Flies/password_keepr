package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.repositories.UserRepository
import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.ui.viewModels.PasswordVaultViewModel
import com.soupflies.keepr_mpp.ui.views.PasswordVaultView

class PasswordVaultPresenter(val view: PasswordVaultView, val viewModel: PasswordVaultViewModel) {

    val userRepo = UserRepository()

    fun getArchivedAccounts() {

        val userResponse = userRepo.getCurrentUser()

        viewModel.userAccounts.value = userResponse?.accounts ?: listOf()
    }

    fun addNewAccount() { view.navigateToCreateAccount() }


    fun removeAccount() {}
}