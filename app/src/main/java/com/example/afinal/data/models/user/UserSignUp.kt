package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class UserSignUp(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("confirm_password")
    val confirmPassword: String,
    @SerializedName("password")
    val password: String,

)