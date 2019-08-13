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
) {

    fun encryptPassword(hashKey: String): String {
        // This could likely be based on a generated value from the users passwordHash -- then from that password hash
        // We could also decrypt the account passwords once they are ready to be viewed.
        // Best to use library from people that actually know what they are doing, this is just for demonstration purposes.

        // Obfuscation of data is better done with bcrypt, but that is unidirectional

        return password.reversed()
    }

    fun decryptPassword(hashKey: String) = password

    companion object {
        fun fromString(input: String): Account {
            val cleanString = input.drop(8).dropLast(1)

            val propMap: Map<String, String> = cleanString.split(", ").associate {
                val split = it.split("=")
                val key = split[0]
                val value = if (split[1] !== "null") split[1] else ""
                key to value
            }

            return Account(
                propMap.getOrElse("title") { "" },
                propMap.getOrElse("username") { "" },
                propMap.getOrElse("email") { "" },
                propMap.getOrElse("password") { "" },
                propMap.getOrElse("website") { "" },
                propMap.getOrElse("notes") { "" }
            )

        }
    }
}

