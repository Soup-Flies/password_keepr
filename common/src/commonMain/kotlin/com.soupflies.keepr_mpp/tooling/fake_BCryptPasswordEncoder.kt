package com.soupflies.keepr_mpp.tooling


// TODO: Could not get spring bcrypt to properly resolve.
class fake_BCryptPasswordEncoder {

    private val secure_string = "secure"

    fun encode(string: String): String {

        return string.zip(secure_string).toString()
    }
}