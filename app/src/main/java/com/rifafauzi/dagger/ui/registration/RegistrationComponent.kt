package com.rifafauzi.dagger.ui.registration

import com.rifafauzi.dagger.di.ActivityScope
import com.rifafauzi.dagger.ui.detail.EnterDetailFragment
import com.rifafauzi.dagger.ui.terms.TermsAndConditionsFragment
import dagger.Subcomponent

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailFragment)
    fun inject(fragment: TermsAndConditionsFragment)
}