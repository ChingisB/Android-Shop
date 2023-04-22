package com.example.afinal.data.models.cart

import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("cart")
    val cart: List<CartItem>
)
