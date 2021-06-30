package com.magicbytes.thedogapp_cv.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogBreed(val name: String, val temperament: String, @SerializedName("life_span") val lifeSpan: String, val image: Image, val id: Int) :
    Parcelable {

    @Parcelize
    data class Image(val url: String) : Parcelable
}
