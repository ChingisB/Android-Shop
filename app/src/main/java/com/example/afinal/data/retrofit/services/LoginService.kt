package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.user.UserLogin
import com.example.afinal.data.models.user.UserWithToken
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("login")
    suspend fun login(@Body userLogin: UserLogin): UserWithToken

    @POST("logout")
    suspend fun logout(){}
}