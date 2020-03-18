package com.example.covid19realtime.utils

import java.util.*

fun getCountryCode(countryName: String): String? {
    val locale: Locale = Locale.ENGLISH
    Locale.setDefault(locale)

    if(countryName != "USA" && countryName != "UK" && countryName != "S. Korea"){
        return Locale.getISOCountries().find {
            Locale( "", it).displayCountry == countryName
        }
    }
    else if(countryName == "UK"){
        return "gb"
    }
    else if(countryName == "S. Korea"){
        return "kr"
    }
    else if(countryName == "USA"){
        return "us"
    }
    else {
        return ""
    }
}