package com.soupflies.keepr_mpp.tooling

import platform.Foundation.NSLog

actual class Logger {
    actual companion object {
        actual fun d(tag: String, message: String) = NSLog("[Debug]: ($tag), $message")

        actual fun i(tag: String, message: String) = NSLog("[Info]: ($tag), $message")

        actual fun w(tag: String, message: String) = NSLog("[Warn]: ($tag), $message")

        actual fun e(tag: String, message: String, throwable: Throwable) = NSLog("[Error]: ($tag), $message, $throwable")

    }

}