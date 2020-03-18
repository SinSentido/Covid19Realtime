package com.example.covid19realtime.ui.country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid19realtime.database.CoronaApiService
import com.example.covid19realtime.pojos.Country
import kotlin.concurrent.thread

class CountryViewModel(private val coronaApiService: CoronaApiService): ViewModel() {

    fun getCountryByName(countryName: String): LiveData<Country>{
        var country: MutableLiveData<Country> = MutableLiveData()

        thread {
            country.postValue(coronaApiService.getCountryByName(countryName).execute().body())
        }

        return country
    }
}