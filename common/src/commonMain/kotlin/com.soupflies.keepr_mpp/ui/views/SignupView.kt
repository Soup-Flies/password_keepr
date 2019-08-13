package com.soupflies.keepr_mpp.ui.views

interface SignupView: BaseView {

    fun validateInput(): Boolean

    fun navigateToPasswordVault()

}