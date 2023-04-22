package com.example.afinal.data.models.cart

import com.google.gson.annotations.SerializedName

data class CreateCart(
    @SerializedName("cart")
    val cart: List<CreateCartItem>
)
