package com.example.afinal.data.models.order


import com.example.afinal.data.models.user.User
import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("payment")
    val payment: Payment,
    @SerializedName("total")
    val total: Int,
    @SerializedName("user")
    val user: User
)