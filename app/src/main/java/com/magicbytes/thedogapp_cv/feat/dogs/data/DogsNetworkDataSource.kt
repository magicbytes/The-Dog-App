package com.magicbytes.thedogapp_cv.feat.dogs.data

import com.magicbytes.thedogapp_cv.api.DogsService
import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.utility.ServiceResponse
import timber.log.Timber
import javax.inject.Inject

class DogsNetworkDataSource @Inject constructor(private val dogsService: DogsService) : DogsRepository.DataSource {

    override suspend fun loadAllBreeds(): ServiceResponse<List<DogBreed>> {
        val response = dogsService.getAllBreeds()

        return if (response.isSuccessful) {
            ServiceResponse.Success(response.body().orEmpty())
        } else {
            val errorMessage = response.errorBody()?.string()
            Timber.e("There was an issue when loading all breeds: $errorMessage")
            ServiceResponse.Error()
        }
    }
}
