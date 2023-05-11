package com.example.afinal.data.retrofit.services

import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface LikeService {
    @POST("products/{productID}/likes")
    suspend fun likeProduct(@Path("productID") productID: Int)

    @DELETE("products/{productID}/likes")
    suspend fun dislikeProduct(@Path("productID") productID: Int)
}