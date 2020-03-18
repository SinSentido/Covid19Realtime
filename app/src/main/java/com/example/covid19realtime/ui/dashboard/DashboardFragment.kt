package com.example.covid19realtime.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

import com.example.covid19realtime.R
import com.example.covid19realtime.database.CoronaApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dashboard_fragment.*

class DashboardFragment : Fragment(R.layout.dashboard_fragment) {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(this)
    }

    private val viewModel: DashboardViewModel by viewModels {
        DashboardViewModelFactory(CoronaApi.coronaApiService)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
            setupViews(requireView())
    }

    private fun setupViews(view: View) {
        setupToolbar()
        setGlobalStatistics()
    }

    private fun setupToolbar() {
        dashboard_btn_countries.setOnClickListener { navController.navigate(R.id.countriesDestination) }
        requireActivity().toolbar.menu.clear()
        requireActivity().toolbar.inflateMenu(R.menu.main_menu)
        requireActivity().toolbar.setOnMenuItemClickListener{
            when (it.itemId){
                R.id.mnu_countries -> {navController.navigate(R.id.countriesDestination)}
            }
            true
        }
    }

    private fun setGlobalStatistics(){
        viewModel.getGlobalStatistics().observe(viewLifecycleOwner){
             if(it != null){
                 dashboard_cases.text = it.cases.toString()
                 dashboard_recovered.text = it.recovered.toString()
                 dashboard_deaths.text = it.deaths.toString()
             }
        }
    }


}
