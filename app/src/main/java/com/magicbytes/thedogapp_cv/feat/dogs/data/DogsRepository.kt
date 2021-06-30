package com.magicbytes.thedogapp_cv.feat.dogs.data

import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.utility.ServiceResponse
import javax.inject.Inject

class DogsRepository @Inject constructor(private val dataSource: DataSource) {

    private var allBreedsCache: List<DogBreed> = emptyList()

    suspend fun loadAllBreeds(): ServiceResponse<List<DogBreed>> {
        allBreedsCache = emptyList()

        val response = dataSource.loadAllBreeds()
        response.onSuccess { allBreedsCache = it }

        return response
    }

    fun searchBreed(filter: String): List<DogBreed> {
        return allBreedsCache.filter { it.name.contains(filter, ignoreCase = true) }
    }

    interface DataSource {
        suspend fun loadAllBreeds(): ServiceResponse<List<DogBreed>>
    }
}
