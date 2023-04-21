package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.product.Vendor
import retrofit2.http.*

interface VendorService {

    @GET("vendor/")
    suspend fun getVendors(): List<Vendor>

    @GET("vendor/{vendorID}/")
    suspend fun getVendor(@Path("vendorID") vendorID: Int): Vendor

    @POST("vendor/")
    suspend fun createVendor(@Body vendor: Vendor): Vendor

    @PUT("vendor/{vendorID}/")
    suspend fun updateVendor(@Path("vendorID") vendorID: Int, @Body vendor: Vendor): Vendor

    @DELETE("vendor/{vendorID}/")
    suspend fun deleteVendor(@Path("vendorID") vendorID: Int)
}