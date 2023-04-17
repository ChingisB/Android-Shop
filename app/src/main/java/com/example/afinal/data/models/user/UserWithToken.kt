package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class UserWithToken(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: User
)