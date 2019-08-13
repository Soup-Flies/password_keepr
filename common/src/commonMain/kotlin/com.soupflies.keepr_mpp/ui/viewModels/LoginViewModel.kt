package com.soupflies.keepr_mpp.ui.viewModels

import com.soupflies.keepr_mpp.tooling.Observable
import com.soupflies.keepr_mpp.ui.viewModels.modelState.LoginViewState
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object LoginViewModel {

    val currentState = Observable<LoginViewState>(LoginViewState.Biometric)

    val password = Observable<String>("")

}