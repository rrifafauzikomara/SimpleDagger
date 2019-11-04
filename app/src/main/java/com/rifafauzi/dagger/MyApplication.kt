package com.rifafauzi.dagger

import android.app.Application
import com.rifafauzi.dagger.di.AppComponent
import com.rifafauzi.dagger.di.DaggerAppComponent

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}