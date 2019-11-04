package com.rifafauzi.dagger.ui.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.rifafauzi.dagger.MyApplication
import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.ui.login.LoginActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val userManager = (application as MyApplication).userManager

        settingsViewModel = SettingsViewModel(userManager.userDataRepository!!, userManager)
        initView()
    }

    private fun initView() {
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
