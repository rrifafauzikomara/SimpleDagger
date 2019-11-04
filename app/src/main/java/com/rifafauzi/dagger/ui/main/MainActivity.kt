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
import com.rifafauzi.dagger.user.UserManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)


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

            initView()
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.tvNotif).text = mainViewModel.notificationsText
    }

    private fun initView() {
        findViewById<TextView>(R.id.tvHello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.btnSetting).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
