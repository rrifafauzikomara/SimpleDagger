package com.rifafauzi.dagger.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.rifafauzi.dagger.MyApplication
import com.rifafauzi.dagger.R
import com.rifafauzi.dagger.login.LoginActivity
import com.rifafauzi.dagger.registration.RegistrationActivity
import com.rifafauzi.dagger.setting.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userManager = (application as MyApplication).userManager
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
            mainViewModel = MainViewModel(userManager.userDataRepository!!)
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
