package com.soupflies.keepr.ui.biometric

import android.os.Build

class BiometricSetup {

    fun isBiometricPromptEnabled() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
    }
}