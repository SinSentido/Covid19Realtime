package com.example.covid19realtime.ui.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covid19realtime.database.CoronaApiService

class CountryViewModelFactory(private val coronaApiService: CoronaApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        CountryViewModel(coronaApiService) as T
}