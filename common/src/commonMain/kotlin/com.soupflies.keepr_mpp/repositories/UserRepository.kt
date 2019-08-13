package com.soupflies.keepr_mpp.repositories

import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.serialized.User

class UserRepository {
    private var currentUser: User? = null


    fun logUserIn(password: String): User? {
        TODO("not implemented")
    }

    fun updateUser(user: User): Boolean {
        TODO("not implemented")
    }

    fun getCurrentUser(): User? {

        if (currentUser != null) return currentUser
        else {
            // Get user information from storage

        }
        TODO("not implemented")
    }

    fun saveUser(user: User): Boolean {
        TODO("not implemented")
    }

    fun addAccountToUser(account: Account): String? {
        TODO("not implemented")
    }

    fun editAccountForUser(account: Account): String? {
        TODO("not implemented")
    }

    fun removeAccountFromUser(account: Account): Boolean {
        TODO("not implemented")
    }

    fun sendUserGeneratedCode(): String {
        TODO("not implemented")
    }
}