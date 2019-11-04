package com.rifafauzi.dagger.di

import android.content.Context
import com.rifafauzi.dagger.storage.SharedPreferencesStorage
import com.rifafauzi.dagger.storage.Storage
import dagger.Module
import dagger.Provides

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@Module
class StorageModule {

    @Provides
    fun provideStorage(context: Context) : Storage = SharedPreferencesStorage(context)
}