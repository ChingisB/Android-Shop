package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.user.User
import com.example.afinal.data.models.user.UserSignUp
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StaffService {

    @POST("staff")
    suspend fun createStaff(@Body userSignUp: UserSignUp): User

    @GET("staff")
    suspend fun getAllStaff(): List<User>

    @GET("staff/{staffID}")
    suspend fun getStaff(@Path("staffID") staffID: Int): User

    @DELETE("staff/{staffID}")
    suspend fun deleteStaff(@Path("staffID") staffID: Int)
}