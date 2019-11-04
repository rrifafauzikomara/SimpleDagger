package com.rifafauzi.dagger.ui.setting

import com.rifafauzi.dagger.user.UserDataRepository
import com.rifafauzi.dagger.user.UserManager
import javax.inject.Inject

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

class SettingsViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val userManager: UserManager
) {

    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
}