package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.user.UserInfo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserInfoService {
    @GET("userinfo/")
    suspend fun getUserInfo(): UserInfo

    @POST("userinfo/")
    suspend fun createUserInfo(@Body userInfo: UserInfo): UserInfo

    @PUT("userinfo/")
    suspend fun updateUserInfo(@Body userInfo: UserInfo): UserInfo
}