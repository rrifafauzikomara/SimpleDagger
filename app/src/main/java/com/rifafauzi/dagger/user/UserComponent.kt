package com.rifafauzi.dagger.user

import com.rifafauzi.dagger.ui.main.MainActivity
import com.rifafauzi.dagger.ui.setting.SettingsActivity
import dagger.Subcomponent

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@LoggedUserScope
@Subcomponent
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: SettingsActivity)
}