package com.rifafauzi.dagger.di

import android.content.Context
import com.rifafauzi.dagger.ui.registration.RegistrationActivity
import dagger.BindsInstance
import dagger.Component

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@Component(modules = [StorageModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: RegistrationActivity)
}