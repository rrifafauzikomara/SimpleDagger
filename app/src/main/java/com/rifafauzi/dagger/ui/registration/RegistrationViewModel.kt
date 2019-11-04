package com.rifafauzi.dagger.ui.registration

import com.rifafauzi.dagger.di.ActivityScope
import com.rifafauzi.dagger.user.UserManager
import javax.inject.Inject

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

@ActivityScope
class RegistrationViewModel @Inject constructor(private val userManager: UserManager) {

    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean? = null

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        assert(username != null)
        assert(password != null)
        assert(acceptedTCs == true)

        userManager.registerUser(username!!, password!!)
    }
}