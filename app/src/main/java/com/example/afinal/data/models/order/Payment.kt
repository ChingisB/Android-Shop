package com.example.afinal.data.models.order


import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("status")
    val status: String
)