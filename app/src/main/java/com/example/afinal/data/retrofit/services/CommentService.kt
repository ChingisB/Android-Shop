package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.product.Comment
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentService {
    @GET("products/{productID}/comments/")
    suspend fun getComments(@Path("productID") productID: Int): List<Comment>

    @GET("products/{productID}/comments/{commentID}/")
    suspend fun getComment(@Path("productID") productID: Int, @Path("commentID") commentID: Int): Comment

    @POST("products/{productID}/comments/")
    suspend fun createComment(@Path("productID") productID: Int, @Body text: String): Comment

    @DELETE("products/{productID}/comments/{commentID}/")
    suspend fun deleteComment(@Path("productID") productID: Int, @Path("commentID") commentID: Int)
}