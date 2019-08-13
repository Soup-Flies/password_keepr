package com.soupflies.keepr_mpp.repositories

import com.netguru.kissme.Kissme
import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.serialized.User
import com.soupflies.keepr_mpp.tooling.fake_BCryptPasswordEncoder
import kotlin.random.Random


class UserRepository {
    private var currentUser: User? = null

    private val storage = Kissme("the_secretest_storage_v2")

    fun getUserCredentialHash(): String = storage.getString("password_hash", "")!!

    fun logUserIn(password: String): User? {
        val hash = fake_BCryptPasswordEncoder().encode(password)

        val storedHash = storage.getString("password_hash", "")

        return if (storedHash != null && hash == storedHash) retrieveUserAccount()
        else null
    }

    fun updateUser(user: User): Boolean = storeUserAccount(user)

    fun getCurrentUser(): User? {
        return if (currentUser != null) currentUser
        else retrieveUserAccount()
    }

    fun saveUser(user: User): Boolean = storeUserAccount(user)


    fun addAccountToUser(account: Account): String? {
        val user = getCurrentUser()

        return if (user != null) {
            val accountList = user.accounts.plus(account)

            val newUser = user.copy(accounts = accountList)
            currentUser = newUser

            storage.putString("account_${accountList.size}", account.toString())

            null
        } else "Error adding account: User not Logged in"
    }

    fun editAccountForUser(account: Account): String? {
        val user = getCurrentUser()

        return if (user != null) {
            val index = user.accounts.indexOf(account)

            val accountList = user.accounts.toMutableList()
            accountList[index] = account

            val newUser = user.copy(accounts = accountList)
            currentUser = newUser

            if (index == -1) return addAccountToUser(account)

            storage.putString("account_$index", account.toString())

            null
        } else "Error updating stored account: User not Logged in"
    }

    fun removeAccountFromUser(account: Account): Boolean {
        val user = getCurrentUser()

        return if (user != null) {
            val index = user.accounts.indexOf(account)
            val accountList = user.accounts.subList(index, index + 1)
            currentUser = user.copy(accounts = accountList)
            storage.remove("account_$index")

            true
        } else false
    }

    fun sendUserGeneratedCode(): String {
        return Random.nextInt(42).toString()
    }

    private fun retrieveUserAccount(): User {
        val usernameExists = storage.getString("user_name", null)
        return if (usernameExists != null) {

            // With a more robust storage I would avoid the assert-not-null
            User(
                usernameExists,
                storage.getString("email", "")!!,
                storage.getString("password_hash", "")!!,
                gatherUserAccounts(),
                storage.getBoolean("use_biometrics", false)
            )
        } else User("", "", "", listOf(), false)
    }

    private fun gatherUserAccounts(): List<Account> {
        val size = storage.getInt("accounts_length", 0)

        val tempList: MutableList<Account> = mutableListOf()

        for (i in 0 until size) {
            val stringAccount = storage.getString("account_$i", "")

            if (stringAccount != null && stringAccount != "" ) {
                tempList.add(Account.fromString(stringAccount))
            }
        }

        return tempList.toList()
    }

    private fun storeUserAccount(user: User): Boolean {
        with(user) {
            val passwordHash = fake_BCryptPasswordEncoder().encode(password)

            storage.putString("user_name", userName)
            storage.putString("email", email)
            storage.putString("password_hash", passwordHash)
            storage.putInt("accounts_length", accounts.size)
            storage.putBoolean("use_biometrics", useBiometrics)
        }
        return true
    }
}