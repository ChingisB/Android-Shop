package com.example.afinal.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {
        private var token: String? = null

        fun getInstance(): Retrofit {
            if (token != null) {
                return Retrofit.Builder().baseUrl(Config.getApiUrl())
                    .addConverterFactory(GsonConverterFactory.create()).client(
                        OkHttpClient.Builder().addInterceptor(TokenInterceptor(token!!)).build()
                    ).build()
            }
            return Retrofit.Builder().baseUrl(Config.getApiUrl())
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        fun setToken(token: String) {
            this.token = token
        }

        fun deleteToken(){
            this.token = null
        }

}
}