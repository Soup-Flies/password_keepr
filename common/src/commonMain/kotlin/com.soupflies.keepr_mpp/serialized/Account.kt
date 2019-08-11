package com.soupflies.keepr_mpp.serialized

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val title: String,
    val username: String?,
    val email: String?,
    val password: String,
    val website: String?,
    val notes: String?
)