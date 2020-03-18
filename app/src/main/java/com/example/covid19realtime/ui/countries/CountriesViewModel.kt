package com.example.covid19realtime.ui.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid19realtime.database.CoronaApiService
import com.example.covid19realtime.pojos.Country
import kotlin.concurrent.thread

class CountriesViewModel(private val coronaApiService: CoronaApiService): ViewModel() {

    private var countries: MutableLiveData<List<Country>> = MutableLiveData()
    val countriesObserve: LiveData<List<Country>> get() = countries

    fun getAllCountries() {
        thread {
            countries.postValue(coronaApiService.getAllCountries().execute().body())
        }
    }

    fun filterCountries(countryName: String): List<Country>{
        return countries.value!!.filter {
            it.country.toLowerCase().matches((".*" + countryName.toLowerCase() +".*").toRegex())
        }
    }
}