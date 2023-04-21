package com.example.afinal.data.models.user


import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postal_code")
    val postalCode: String,
    @SerializedName("telephone")
    val telephone: String,
    @SerializedName("user")
    val user: User
) {
    constructor(
        address: String,
        city: String,
        country: String,
        postalCode: String,
        telephone: String
    ) : this(address, city, country, postalCode, telephone, User("", "", "", ""))
}