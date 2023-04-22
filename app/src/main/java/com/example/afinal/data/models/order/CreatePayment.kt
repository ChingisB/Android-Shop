package com.example.afinal.data.models.order


import com.google.gson.annotations.SerializedName

data class CreatePayment(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("status")
    val status: String
)