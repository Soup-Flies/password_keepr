package com.soupflies.keepr_mpp.ui.presenters.interfaces

interface InputField {
    val pattern: Regex

    val errorMessage: String

    fun checkPattern(input: String): Boolean = pattern.matches(input)
}