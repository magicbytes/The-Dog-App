package com.magicbytes.thedogapp_cv.api

import com.magicbytes.thedogapp_cv.api.data.DogBreed
import retrofit2.Response
import retrofit2.http.GET

interface DogsService {
    @GET("v1/breeds")
    suspend fun getAllBreeds(): Response<List<DogBreed>>
}
