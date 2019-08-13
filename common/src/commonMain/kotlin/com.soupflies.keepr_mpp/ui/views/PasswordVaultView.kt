package com.soupflies.keepr_mpp.ui.views

import com.soupflies.keepr_mpp.serialized.Account

interface PasswordVaultView {

    fun navigateToAccount(account: Account)

    fun navigateToCreateAccount()

}