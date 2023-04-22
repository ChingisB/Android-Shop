package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.order.CreateOrder
import com.example.afinal.data.models.order.Order
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface OrderService {
    @GET("orders/")
    suspend fun getOrders(): List<Order>

    @GET("orders/{orderID}")
    suspend fun getOrder(@Path("orderID") orderID: Int): Order

    @POST("orders/")
    suspend fun createOrder(@Body createOrder: CreateOrder): Order
}