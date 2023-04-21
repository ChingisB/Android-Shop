package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.user.PaymentInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PaymentInfoService {
    @GET("payment_info/")
    suspend fun getPaymentInfo(): PaymentInfo

    @POST("payment_info/")
    suspend fun createPaymentInfo(@Body paymentInfo: PaymentInfo): PaymentInfo
}