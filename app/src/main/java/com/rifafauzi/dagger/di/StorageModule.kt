package com.rifafauzi.dagger.di

import com.rifafauzi.dagger.storage.SharedPreferencesStorage
import com.rifafauzi.dagger.storage.Storage
import dagger.Binds
import dagger.Module

/**
 * Created by rrifafauzikomara on 2019-11-04.
 */

@Module
abstract class StorageModule {

    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage) : Storage
}