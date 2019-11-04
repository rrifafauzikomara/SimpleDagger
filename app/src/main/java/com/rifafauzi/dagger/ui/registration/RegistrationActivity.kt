package com.rifafauzi.dagger.ui.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rifafauzi.dagger.MyApplication
import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.main.MainActivity
import com.rifafauzi.dagger.ui.detail.EnterDetailFragment
import com.rifafauzi.dagger.ui.terms.TermsAndConditionsFragment
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity() {

    lateinit var registrationComponent: RegistrationComponent

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        registrationComponent = (application as MyApplication).appComponent
            .registrationComponent().create()

        registrationComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailFragment())
            .commit()
    }

    fun onDetailEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}