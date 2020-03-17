package com.example.covid19realtime.pojos

import com.google.gson.annotations.SerializedName

data class GlobalStatistics (
    @SerializedName("cases") val cases : Int,
    @SerializedName("deaths") val deaths : Int,
    @SerializedName("recovered") val recovered : Int,
    @SerializedName("updated") val updated : Long
)
