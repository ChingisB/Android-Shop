package com.example.afinal.data.models.product


import com.google.gson.annotations.SerializedName

data class CreateProduct(
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("vendor_id")
    val vendorId: Int
)