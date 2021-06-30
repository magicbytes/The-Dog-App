package com.magicbytes.thedogapp_cv.di

import com.magicbytes.thedogapp_cv.utility.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object UtilityModule {
    @Provides
    fun provideDispatchers(): AppCoroutineDispatchers {
        return AppCoroutineDispatchers(
            Dispatchers.IO,
            Dispatchers.Default,
            Dispatchers.IO,
            Dispatchers.Main
        )
    }
}
