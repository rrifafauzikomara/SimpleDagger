package com.rifafauzi.dagger.main

import com.rifafauzi.dagger.user.UserDataRepository

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */
 
class MainViewModel(private val userDataRepository: UserDataRepository) {
    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"

    val notificationsText: String
        get() = "You have ${userDataRepository.unReadNotification} unread notifications"
}