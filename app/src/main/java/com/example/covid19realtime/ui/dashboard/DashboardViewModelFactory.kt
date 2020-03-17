package com.example.covid19realtime.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covid19realtime.database.CoronaApiService
import retrofit2.Retrofit

class DashboardViewModelFactory(val coronaApiService: CoronaApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        DashboardViewModel(coronaApiService) as T
}