package com.rifafauzi.dagger.setting

import com.rifafauzi.dagger.user.UserDataRepository
import com.rifafauzi.dagger.user.UserManager

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

class SettingsViewModel(private val userDataRepository: UserDataRepository, private val userManager: UserManager) {
    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
}