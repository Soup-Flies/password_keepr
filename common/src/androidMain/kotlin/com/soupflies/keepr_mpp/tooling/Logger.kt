package com.soupflies.keepr_mpp.tooling

import android.util.Log

actual class Logger {
    actual companion object {
        actual fun d(tag: String, message: String) {
            Log.d(tag, message)
        }

        actual fun w(tag: String, message: String) {
            Log.w(tag, message)
        }

        actual fun i(tag: String, message: String) {
            Log.i(tag, message)
        }

        actual fun e(tag: String, message: String, throwable: Throwable) {
            Log.e(tag, message, throwable)
        }
    }
}