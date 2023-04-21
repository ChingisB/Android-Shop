package com.example.afinal.data.retrofit.services

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ProductService {
    @Multipart
    @POST("products/")
    suspend fun createProduct(
        @Part("product_info") productInfo: RequestBody,
        @Part images: List<MultipartBody.Part>
    )
}