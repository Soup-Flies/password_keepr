package com.soupflies.keepr_mpp.ui.views

interface LoginView: BaseView {

    fun isBiometricCapable(): Boolean

    fun navigateToForgotPassword()

    fun navigateToPasswordVault()

}