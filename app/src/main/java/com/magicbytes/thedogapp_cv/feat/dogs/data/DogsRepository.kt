package com.magicbytes.thedogapp_cv.feat.dogs.data

import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.utility.ServiceResponse
import javax.inject.Inject

class DogsRepository @Inject constructor(private val dataSource: DataSource) {

    suspend fun loadAllBreeds(): ServiceResponse<List<DogBreed>> {
        return dataSource.loadAllBreeds()
    }

    interface DataSource {
        suspend fun loadAllBreeds(): ServiceResponse<List<DogBreed>>
    }
}
