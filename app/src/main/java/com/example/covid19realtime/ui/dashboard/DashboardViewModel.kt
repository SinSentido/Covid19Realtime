package com.example.covid19realtime.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid19realtime.pojos.GlobalStatistics
import com.example.covid19realtime.database.CoronaApiService
import kotlin.concurrent.thread

class DashboardViewModel(private val coronaApiService: CoronaApiService): ViewModel() {

    fun getGlobalStatistics(): LiveData<GlobalStatistics> {
        val globalStatistics: MutableLiveData<GlobalStatistics> = MutableLiveData()
        globalStatistics.value = null

        thread {
            globalStatistics.postValue(coronaApiService.getGlobalStatistics().execute().body())
        }

        return globalStatistics
    }

}