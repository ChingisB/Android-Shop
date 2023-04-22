package com.example.afinal.data.models.order


import com.example.afinal.data.models.product.Product
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("product")
    val product: Product,
    @SerializedName("quantity")
    val quantity: Int
)