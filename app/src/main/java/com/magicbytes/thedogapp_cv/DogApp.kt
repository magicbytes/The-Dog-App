package com.magicbytes.thedogapp_cv

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class DogApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
