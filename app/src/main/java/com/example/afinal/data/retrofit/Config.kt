package com.example.afinal.data.retrofit

object Config {
    private val apiUrl = "http://192.168.100.10:8000/"


    fun getApiUrl(): String {return this.apiUrl}
}