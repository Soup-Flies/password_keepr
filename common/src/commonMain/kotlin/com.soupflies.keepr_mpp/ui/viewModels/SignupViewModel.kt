package com.soupflies.keepr_mpp.ui.viewModels

import com.soupflies.keepr_mpp.tooling.Observable
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object SignupViewModel {

    val username = Observable<String>("")
    val usernameError = Observable<String>("")

    val email = Observable<String>("")
    val emailError = Observable<String>("")

    val password = Observable<String>("")
    val passwordError = Observable<String>("")

    val useBiometrics = Observable<Boolean>(true)



}