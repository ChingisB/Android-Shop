package com.example.afinal.data.models.product


import com.example.afinal.data.models.user.UserBrief
import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("id")
    val id: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("user")
    val user: UserBrief
) {
    constructor(text: String, user: UserBrief) : this(0, text, UserBrief("", "", ""))
}