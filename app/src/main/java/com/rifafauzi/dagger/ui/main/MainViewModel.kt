package com.rifafauzi.dagger.ui.main

import com.rifafauzi.dagger.user.UserDataRepository
import javax.inject.Inject

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

class MainViewModel @Inject constructor(private val userDataRepository: UserDataRepository) {

    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"

    val notificationsText: String
        get() = "You have ${userDataRepository.unReadNotification} unread notifications"

}