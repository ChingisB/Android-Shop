package com.example.afinal.data.models.cart


import com.example.afinal.data.models.product.Product
import com.google.gson.annotations.SerializedName

data class CartItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("product")
    val product: Product,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("shopping_session")
    val shoppingSession: Int
)