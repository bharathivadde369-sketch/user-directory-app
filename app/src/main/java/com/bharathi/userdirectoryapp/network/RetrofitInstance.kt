package com.bharathi.userdirectoryapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: UserApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://fake-json-api.mock.beeceptor.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
}