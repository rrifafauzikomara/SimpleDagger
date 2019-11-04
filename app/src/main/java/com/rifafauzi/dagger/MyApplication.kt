package com.rifafauzi.dagger

import android.app.Application
import com.rifafauzi.dagger.di.AppComponent
import com.rifafauzi.dagger.di.DaggerAppComponent
import com.rifafauzi.dagger.storage.SharedPreferencesStorage
import com.rifafauzi.dagger.user.UserManager

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */
 
open class MyApplication : Application() {

    open val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }

}