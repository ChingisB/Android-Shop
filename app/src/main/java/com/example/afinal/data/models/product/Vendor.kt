package com.example.afinal.data.models.product


import com.google.gson.annotations.SerializedName

data class Vendor(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    )
{
    constructor(name: String, description: String) : this(0, name, description) {}
}