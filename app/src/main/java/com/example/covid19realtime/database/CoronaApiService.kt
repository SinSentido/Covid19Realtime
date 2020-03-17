package com.example.covid19realtime.database

import com.example.covid19realtime.pojos.Country
import com.example.covid19realtime.pojos.GlobalStatistics
import retrofit2.Call
import retrofit2.http.GET

interface CoronaApiService {

    //Get all the countries statistics
     @GET("all") fun getGlobalStatistics(): Call<GlobalStatistics>

     //Get a list with all the affected countries
     @GET("countries") fun getAllCountries(): Call<List<Country>>

}