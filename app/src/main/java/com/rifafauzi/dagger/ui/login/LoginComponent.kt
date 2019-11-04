package com.rifafauzi.dagger.ui.login

import com.rifafauzi.dagger.di.ActivityScope
import dagger.Subcomponent

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)
}