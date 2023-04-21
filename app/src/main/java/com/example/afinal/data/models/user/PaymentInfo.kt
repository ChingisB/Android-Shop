package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class PaymentInfo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("account_no")
    val accountNo: String,
    @SerializedName("expiry")
    val expiry: String,
    @SerializedName("payment_type")
    val paymentType: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("user")
    val user: User
) {
    constructor(accountNo: String, expiry: String, paymentType: String, provider: String) : this(
        0,
        accountNo,
        expiry,
        paymentType,
        provider,
        User("", "", "", "")
    )
}