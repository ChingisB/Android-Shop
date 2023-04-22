package com.example.afinal.data.models.product


import com.google.gson.annotations.SerializedName

data class ProductDetails(
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
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("inventory")
    val inventory: Inventory,
    @SerializedName("is_liked")
    val isLiked: Boolean,
    @SerializedName("likes")
    val likes: Int,
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