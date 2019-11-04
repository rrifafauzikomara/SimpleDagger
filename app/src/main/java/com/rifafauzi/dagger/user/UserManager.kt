package com.rifafauzi.dagger.user

import com.rifafauzi.dagger.storage.Storage
import javax.inject.Inject

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"
 
class UserManager @Inject constructor(private val storage: Storage) {

    var userDataRepository: UserDataRepository? = null
    val username: String
    get() = storage.getString(REGISTERED_USER)

    fun isUserLoggedIn() = userDataRepository != null

    fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

    private fun userJustLoggedIn() {
        userDataRepository = UserDataRepository(this)
    }

    fun registerUser(username: String, password: String) {
        storage.setString(REGISTERED_USER, username)
        storage.setString("$username$PASSWORD_SUFFIX", password)
        userJustLoggedIn()
    }

    fun loginUser(username: String, password: String): Boolean {
        val registeredUser = this.username
        if (registeredUser != username) return false

        val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
        if (registeredPassword != password) return false

        userJustLoggedIn()
        return true
    }

    fun logout() {
        userDataRepository = null
    }

    fun unRegister() {
        val username = storage.getString(REGISTERED_USER)
        storage.setString(REGISTERED_USER, "")
        storage.setString("$username$PASSWORD_SUFFIX", "")
        logout()
    }

}