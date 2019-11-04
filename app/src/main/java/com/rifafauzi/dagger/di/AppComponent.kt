package com.rifafauzi.dagger.di

import android.content.Context
import com.rifafauzi.dagger.ui.login.LoginComponent
import com.rifafauzi.dagger.ui.main.MainActivity
import com.rifafauzi.dagger.ui.registration.RegistrationComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@Singleton
@Component(modules = [StorageModule::class, AppSubComponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory

    fun inject(activity: MainActivity)
}