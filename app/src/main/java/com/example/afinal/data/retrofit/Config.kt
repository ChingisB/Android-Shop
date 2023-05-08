package com.example.afinal.data.retrofit

object Config {
    private const val apiUrl = "http://192.168.137.1:8000/"
    fun getApiUrl(): String {return this.apiUrl}
}