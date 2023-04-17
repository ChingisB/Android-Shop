package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_staff")
    val isStaff: Boolean,
    @SerializedName("is_superuser")
    val isSuperuser: Boolean,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("username")
    val username: String
)