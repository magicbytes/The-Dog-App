package com.magicbytes.thedogapp_cv.feat.dogs.data

import com.magicbytes.thedogapp_cv.api.DogsService
import com.magicbytes.thedogapp_cv.api.data.DogBreed
import timber.log.Timber
import javax.inject.Inject

class DogsNetworkDataSource @Inject constructor(private val dogsService: DogsService) :
    DogsRepository.DataSource {

    override suspend fun loadAllBreeds(): Result<List<DogBreed>> {
        return try {
            val response = dogsService.getAllBreeds()

            if (response.isSuccessful) {
                Result.success(response.body().orEmpty())
            } else {
                val errorMessage = response.errorBody()?.string().orEmpty()
                Timber.e("There was an issue when loading all breeds: $errorMessage")
                Result.failure(Throwable(errorMessage))
            }
        } catch (exception: Exception) {
            Timber.e("There was an issue when loading all breeds", exception)
            Result.failure(exception)
        }
    }
}
