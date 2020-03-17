package com.example.covid19realtime.database

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoronaApi {

    companion object{
        val coronaClient: Retrofit = Retrofit.Builder()
            .baseUrl("https://corona.lmao.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}