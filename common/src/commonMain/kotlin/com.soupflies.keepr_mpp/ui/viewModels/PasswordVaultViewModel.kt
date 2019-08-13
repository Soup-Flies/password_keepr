package com.soupflies.keepr_mpp.ui.viewModels

import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.tooling.Observable
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object PasswordVaultViewModel {

    val userAccounts = Observable<List<Account>>(listOf())

}