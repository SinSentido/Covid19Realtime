package com.example.covid19realtime.ui.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.bumptech.glide.Glide

import com.example.covid19realtime.R
import com.example.covid19realtime.database.CoronaApi
import com.example.covid19realtime.utils.getCountryCode
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.country_fragment.*
import java.util.*

class CountryFragment : Fragment(R.layout.country_fragment) {

    private val viewModel: CountryViewModel by viewModels{
        CountryViewModelFactory(CoronaApi.coronaApiService)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        loadCountryInfo()
        setupToolbar()
    }

    private fun setupToolbar() {
        requireActivity().toolbar.menu.clear()
    }

    private fun loadCountryInfo() {
        viewModel.getCountryByName(arguments!!.getString(getString(R.string.country_name_argument))!!).observe(viewLifecycleOwner){
            if(it != null){
                country_lbl_name.text = it.country
                country_cases.text = it.cases.toString()
                country_today_cases.text = it.todayCases.toString()
                country_recovered.text = it.recovered.toString()
                country_deaths.text = it.deaths.toString()
                country_today_deaths.text = it.todayDeaths.toString()
                country_critical.text = it.critical.toString()
                Glide.with(this)
                    .load("https://www.countryflags.io/" + getCountryCode(it.country) + "/flat/64.png")
                    .into(country_img_title)
            }
        }
    }

}
