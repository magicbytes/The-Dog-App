package com.magicbytes.thedogapp_cv.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogsApiNetwork private constructor() {

    private val httpClient: OkHttpClient
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .header("X-Api-Key", "a38c04ec-7f27-4acd-a975-a4285b73107f")
                        .build()

                    chain.proceed(request)
                }
                .build()
        }

    fun get(): DogsService {
        val retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.thedogapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(DogsService::class.java)
    }

    private object Holder {
        val instance = DogsApiNetwork()
    }

    companion object {
        val instance: DogsApiNetwork by lazy { Holder.instance }
    }
}
