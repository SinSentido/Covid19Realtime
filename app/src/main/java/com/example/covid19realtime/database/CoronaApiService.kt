package com.example.covid19realtime.database

import com.example.covid19realtime.dataClasses.Country
import com.example.covid19realtime.dataClasses.GlobalStatistics
import retrofit2.http.GET

interface CoronaApiService {

    //Get all the countries statistics
     @GET("all") fun getGlobalStatistics(): GlobalStatistics

     //Get a list with all the affected countries
     @GET("countries") fun getAllCountries(): List<Country>

}