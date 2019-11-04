package com.rifafauzi.dagger.user

import javax.inject.Inject
import kotlin.random.Random

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */
 
class UserDataRepository @Inject constructor(private val userManager: UserManager) {
    val username: String
    get() = userManager.username

    var unReadNotification: Int

    private fun randomInt(): Int {
        return Random.nextInt(until = 100)
    }

    init {
        unReadNotification = randomInt()
    }

    fun refreshUnreadNotifications() {
        unReadNotification = randomInt()
    }
}