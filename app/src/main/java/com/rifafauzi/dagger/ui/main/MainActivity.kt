package com.rifafauzi.dagger.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.rifafauzi.dagger.MyApplication
import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.login.LoginActivity
import com.rifafauzi.dagger.ui.registration.RegistrationActivity
import com.rifafauzi.dagger.ui.setting.SettingsActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Grabs instance of UserManager from the application graph
        val userManager = (application as MyApplication).appComponent.userManager()
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)

            // If the MainActivity needs to be displayed, we get the UserComponent from the
            // application graph and gets this Activity injected
            userManager.userComponent!!.inject(this)
            setupViews()
        }
    }

    /**
     * Updating unread notifications onResume because they can get updated on SettingsActivity
     */
    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.tvNotif).text = mainViewModel.notificationsText
    }

    private fun setupViews() {
        findViewById<TextView>(R.id.tvHello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.btnSetting).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}