package com.example.covid19realtime.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit

class DashboardViewModelFactory(val client: Retrofit): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        DashboardViewModel(client) as T
}