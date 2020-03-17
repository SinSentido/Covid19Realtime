package com.example.covid19realtime.database

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoronaApi {

    companion object{
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://corona.lmao.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val coronaApiService: CoronaApiService = retrofit.create(CoronaApiService::class.java)
    }
}