package com.rifafauzi.dagger.di

import com.rifafauzi.dagger.ui.login.LoginComponent
import com.rifafauzi.dagger.ui.registration.RegistrationComponent
import dagger.Module

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class])
class AppSubComponents {
}