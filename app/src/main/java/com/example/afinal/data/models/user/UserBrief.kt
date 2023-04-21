package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class UserBrief(
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("username")
    val username: String
){
    constructor(firstName: String, lastName: String, username: String): this(0, firstName, lastName, username)
}