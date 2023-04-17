package com.example.afinal.data.retrofit.services

import com.example.afinal.data.models.user.UserSignUp
import com.example.afinal.data.models.user.UserWithToken
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("signup")
    suspend fun signUp(@Body userSignUp: UserSignUp): UserWithToken
}