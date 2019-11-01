package com.rifafauzi.dagger.storage

import android.content.Context

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

class SharedPreferencesStorage(context: Context) : Storage {

    private val sharedPreferences = context.getSharedPreferences("Dagger", Context.MODE_PRIVATE)

    override fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    override fun getString(key: String): String = sharedPreferences.getString(key, "")!!


}