package com.soupflies.keepr_mpp.serialized

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val userName: String,
    val email: String,
    val password: String,
    val accounts: List<Account> = listOf(),
    val useBiometrics: Boolean
)