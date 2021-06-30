package com.magicbytes.thedogapp_cv.di

import com.magicbytes.thedogapp_cv.api.DogsApiNetwork
import com.magicbytes.thedogapp_cv.api.DogsService
import com.magicbytes.thedogapp_cv.feat.dogs.data.DogsNetworkDataSource
import com.magicbytes.thedogapp_cv.feat.dogs.data.DogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {
    @Provides
    fun provideDogRepoDataSource(dogsService: DogsService): DogsRepository.DataSource {
        return DogsNetworkDataSource(dogsService)
    }

    @Provides
    fun provideDogService(): DogsService {
        return DogsApiNetwork.instance.get()
    }
}
