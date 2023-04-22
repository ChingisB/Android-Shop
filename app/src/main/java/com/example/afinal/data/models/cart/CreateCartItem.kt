package com.example.afinal.data.models.cart


import com.google.gson.annotations.SerializedName

data class CreateCartItem(
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("quantity")
    val quantity: Int
)