package com.soupflies.keepr_mpp.ui.viewModels

import com.soupflies.keepr_mpp.tooling.Observable
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ForgotPasswordViewModel {

    val email = Observable<String>("")

    val resetCode = Observable<String>("")

}