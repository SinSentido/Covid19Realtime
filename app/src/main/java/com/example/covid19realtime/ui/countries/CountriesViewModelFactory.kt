package com.example.covid19realtime.ui.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covid19realtime.database.CoronaApiService
import com.example.covid19realtime.ui.dashboard.DashboardViewModel

class CountriesViewModelFactory(private val coronaApiService: CoronaApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        CountriesViewModel(coronaApiService) as T
}