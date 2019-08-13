package com.soupflies.keepr_mpp.ui.presenters

import com.soupflies.keepr_mpp.repositories.UserRepository
import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.ui.viewModels.AddNewPasswordViewModel
import com.soupflies.keepr_mpp.ui.views.AddNewPasswordView

class AddNewPasswordPresenter(val view: AddNewPasswordView, val viewModel: AddNewPasswordViewModel) {

    private val userRepo = UserRepository()

    private var initialAccount: Account? = null

    fun saveUpdatedAccount(currentAccount: Account?) {
        currentAccount?.let {
            if (initialAccount == null && currentAccount != initialAccount) {
                val accountAddedError = userRepo.addAccountToUser(currentAccount)
                if (accountAddedError == null) {

                    view.alertUser("New Account Added correctly")
                    view.navigateToPasswordVault()

                } else view.alertUser("New Account was not saved successfully: $accountAddedError")
            }
            if (it != initialAccount) {

                val changesSavedError = userRepo.editAccountForUser(currentAccount)

                if (changesSavedError == null) view.alertUser("Changes saved successfully")
                else view.alertUser("Changes were not saved successfully: $changesSavedError")
            }
        }
    }

    fun saveInitialAccount(account: Account?) { initialAccount = account }
}