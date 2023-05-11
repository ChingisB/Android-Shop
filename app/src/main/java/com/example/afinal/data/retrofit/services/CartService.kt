package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.cart.Cart
import com.example.afinal.data.models.cart.CreateCart
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CartService {
    @GET("cart/")
    suspend fun getCart(): Cart

    @POST("cart/")
    suspend fun createCart(@Body createCart: CreateCart): Cart
}