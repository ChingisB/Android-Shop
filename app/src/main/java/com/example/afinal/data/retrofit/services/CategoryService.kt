package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.product.Category
import retrofit2.http.*

interface CategoryService {
    @GET("category/")
    suspend fun getCategories(): List<Category>

    @GET("category/{categoryID}/")
    suspend fun getCategory(@Path("categoryID") categoryID: Int): Category

    @POST("category/")
    suspend fun createCategory(@Body category: Category): Category

    @PUT("category/{categoryID}/")
    suspend fun updateCategory(@Path("categoryID") categoryID: Int, @Body category: Category): Category

    @DELETE("category/{categoryID}")
    suspend fun deleteCategory(@Path("categoryID") categoryID: Int): Category
}