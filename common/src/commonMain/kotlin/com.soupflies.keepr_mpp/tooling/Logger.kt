package com.soupflies.keepr_mpp.tooling


expect class Logger {
    companion object {
        fun d(tag: String, message: String)

        fun w(tag: String, message: String)

        fun i(tag: String, message: String)

        fun e(tag: String, message: String, throwable: Throwable)
    }
}