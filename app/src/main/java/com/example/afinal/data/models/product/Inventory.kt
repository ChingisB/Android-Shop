package com.example.afinal.data.models.product


import com.google.gson.annotations.SerializedName

data class Inventory(
    @SerializedName("quantity")
    val quantity: Int
)