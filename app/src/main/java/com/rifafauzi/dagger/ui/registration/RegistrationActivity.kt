package com.rifafauzi.dagger.ui.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rifafauzi.dagger.MyApplication
import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.main.MainActivity
import com.rifafauzi.dagger.ui.detail.EnterDetailFragment
import com.rifafauzi.dagger.ui.terms.TermsAndConditionsFragment

class RegistrationActivity : AppCompatActivity() {

    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationViewModel =
            RegistrationViewModel((application as MyApplication).userManager)
        supportFragmentManager.beginTransaction().add(R.id.fragment_holder, EnterDetailFragment()).commit()
    }

    fun onDetailEntered() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, TermsAndConditionsFragment()).commit()
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
