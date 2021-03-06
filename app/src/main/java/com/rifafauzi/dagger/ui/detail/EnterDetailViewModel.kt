package com.rifafauzi.dagger.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

private const val MAX_LENGTH = 5

class EnterDetailViewModel @Inject constructor() {

    private val _enterDetailState = MutableLiveData<EnterDetailsViewState>()
    val enterDetailState: LiveData<EnterDetailsViewState>
    get() = _enterDetailState

    fun validateInput(username: String, password: String) {
        when {
            username.length < MAX_LENGTH -> _enterDetailState.value =
                EnterDetailsError("Username has to be longer than 4 characters")
            password.length < MAX_LENGTH -> _enterDetailState.value =
                EnterDetailsError("Password has to be longer than 4 characters")
            else -> _enterDetailState.value = EnterDetailsSuccess
        }
    }
}