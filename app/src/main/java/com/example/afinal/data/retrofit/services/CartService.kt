package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.cart.Cart
import retrofit2.http.GET

interface CartService {
    @GET("cart/")
    fun getCart(): Cart
}