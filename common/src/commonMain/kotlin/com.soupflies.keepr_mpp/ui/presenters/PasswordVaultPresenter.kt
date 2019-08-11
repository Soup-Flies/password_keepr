package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.serialized.Account

class PasswordVaultPresenter(view: BaseView, viewModel: ViewModel): BasePresenter(view, viewModel) {


    fun getArchivedAccounts(): List<Account> {

        // Get current User

        // Return user embedded account information

        return listOf<Account>()
    }

    fun addNewAccount()
}