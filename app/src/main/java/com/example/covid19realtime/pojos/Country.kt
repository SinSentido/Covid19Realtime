package com.example.covid19realtime.pojos

import com.google.gson.annotations.SerializedName

data class Country (

    @SerializedName("country") val country : String,
    @SerializedName("cases") val cases : Int,
    @SerializedName("todayCases") val todayCases : Int,
    @SerializedName("deaths") val deaths : Int,
    @SerializedName("todayDeaths") val todayDeaths : Int,
    @SerializedName("recovered") val recovered : Int,
    @SerializedName("critical") val critical : Int
)