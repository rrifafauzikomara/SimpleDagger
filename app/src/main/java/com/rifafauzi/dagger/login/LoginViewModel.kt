package com.rifafauzi.dagger.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rifafauzi.dagger.user.UserManager

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */
 
class LoginViewModel(private val userManager: UserManager) {
    private val _loginState = MutableLiveData<LoginViewState>()
    val loginState: LiveData<LoginViewState>
    get() = _loginState

    fun login(username: String, password: String) {
        if (userManager.loginUser(username, password)) {
            _loginState.value = LoginSuccess
        } else {
            _loginState.value = LoginError
        }
    }

    fun unRegister() {
        userManager.unRegister()
    }

    fun getUsername(): String = userManager.username
}