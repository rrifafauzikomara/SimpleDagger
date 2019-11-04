package com.rifafauzi.dagger.ui.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.rifafauzi.dagger.MyApplication
import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.login.LoginActivity
import javax.inject.Inject

class SettingsActivity : AppCompatActivity() {

    @Inject
    lateinit var settingsViewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        // Gets the userManager from the application graph to obtain the UserComponent
        // and gets this Activity injected
        val userManager = (application as MyApplication).appComponent.userManager()
        userManager.userComponent!!.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupViews()
    }

    private fun setupViews() {
        findViewById<Button>(R.id.btnRefresh).setOnClickListener {
            settingsViewModel.refreshNotifications()
        }
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            settingsViewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}