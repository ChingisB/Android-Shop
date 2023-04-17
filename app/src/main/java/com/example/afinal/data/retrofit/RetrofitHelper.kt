package com.example.afinal.data.retrofit

import com.example.afinal.data.models.user.UserWithToken
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {
        private var retrofit: Retrofit? = null
        private var token: String? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                if (token != null) {
                    retrofit = Retrofit.Builder().baseUrl(Config.getApiUrl())
                        .addConverterFactory(GsonConverterFactory.create()).client(
                            OkHttpClient.Builder().addInterceptor(TokenInterceptor(token!!)).build()
                        ).build()
                    return retrofit!!
                }
                retrofit = Retrofit.Builder().baseUrl(Config.getApiUrl())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }

        fun setToken(token: String){
            this.token = token
        }
    }
}