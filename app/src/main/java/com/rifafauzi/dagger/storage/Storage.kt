package com.rifafauzi.dagger.storage

/**
 * Created by rrifafauzikomara on 2019-11-01.
 */

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String) : String
}