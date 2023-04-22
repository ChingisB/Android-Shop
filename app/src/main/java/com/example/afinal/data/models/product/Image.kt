package com.example.afinal.data.models.product


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("product")
    val product: Int
)