package com.example.afinal.data.models.cart


import com.example.afinal.data.models.product.Product
import com.google.gson.annotations.SerializedName

data class CartItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("product")
    val product: Product,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("shopping_session")
    val shoppingSession: Int
)