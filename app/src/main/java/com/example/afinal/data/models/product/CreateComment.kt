package com.example.afinal.data.models.product

import com.google.gson.annotations.SerializedName

data class CreateComment(
    @SerializedName("text")
    val text: String
)
