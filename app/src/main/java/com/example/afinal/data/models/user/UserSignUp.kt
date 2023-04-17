package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class UserSignUp(
    @SerializedName("confirm_password")
    val confirmPassword: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)