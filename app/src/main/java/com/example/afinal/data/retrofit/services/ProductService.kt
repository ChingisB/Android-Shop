package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.product.CreateProduct
import com.example.afinal.data.models.product.Product
import com.example.afinal.data.models.product.ProductDetails
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ProductService {
    @Multipart
    @POST("products/")
    suspend fun createProduct(
        @Part("product_info") productInfo: RequestBody,
        @Part images: List<MultipartBody.Part>
    )

    @GET("products/")
    suspend fun getProducts(
        @Query("category") category: String? = null,
        @Query("vendor") vendor: String? = null,
        @Query("name") name: String? = null,
        @Query("min_price") minPrice: Int? = null,
        @Query("max_price") maxPrice: Int? = null
    ): List<Product>

    @GET("products/{productID}/")
    suspend fun getProduct(@Path("productID") productID: Int): ProductDetails

    @PUT("products/{productID}/")
    suspend fun updateProduct(
        @Path("productID") productID: Int,
        @Body createProduct: CreateProduct
    ): ProductDetails

    @DELETE("products/{productID}/")
    suspend fun deleteProduct(@Path("productID") productID: Int): Product

    @GET("liked/")
    suspend fun getLikeProducts(): List<Product>

}