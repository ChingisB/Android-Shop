package com.example.afinal.data.models.order


import com.google.gson.annotations.SerializedName

data class CreateOrder(
    @SerializedName("items")
    val items: List<CreateItem>,
    @SerializedName("payment")
    val payment: CreatePayment
)