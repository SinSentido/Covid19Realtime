package com.example.covid19realtime.ui.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid19realtime.database.CoronaApiService
import com.example.covid19realtime.pojos.Country
import kotlin.concurrent.thread

class CountriesViewModel(private val coronaApiService: CoronaApiService): ViewModel() {

    fun getAllCountries(): LiveData<List<Country>> {
        var countries: MutableLiveData<List<Country>> = MutableLiveData()

        thread {
            countries.postValue(coronaApiService.getAllCountries().execute().body())
        }

        return countries;
    }
}