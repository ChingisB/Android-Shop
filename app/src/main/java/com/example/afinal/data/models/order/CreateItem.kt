package com.example.afinal.data.models.order


import com.google.gson.annotations.SerializedName

data class CreateItem(
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("quantity")
    val quantity: Int
)