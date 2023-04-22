package com.example.afinal.data.models.product


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("category")
    val category: Category,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("discount")
    val discount: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("inventory")
    val inventory: Inventory,
    @SerializedName("is_liked")
    val isLiked: Boolean,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rating")
    val rating: Any,
    @SerializedName("vendor")
    val vendor: Vendor
)