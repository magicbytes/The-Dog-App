package com.magicbytes.thedogapp_cv.api.data

import com.google.gson.annotations.SerializedName

data class DogBreed(val name: String, val temperament: String, @SerializedName("life_span") val lifeSpan: String, val image: Image, val id: Int) {

    data class Image(val url: String)
}
