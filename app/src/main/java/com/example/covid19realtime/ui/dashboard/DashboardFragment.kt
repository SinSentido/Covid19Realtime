package com.example.covid19realtime.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

import com.example.covid19realtime.R
import com.example.covid19realtime.database.CoronaApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dashboard_fragment.*

class DashboardFragment : Fragment(R.layout.dashboard_fragment) {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(this)
    }

    private val viewModel: DashboardViewModel by viewModels {
        DashboardViewModelFactory(CoronaApi.coronaClient)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
            setupViews(requireView())
    }

    private fun setupViews(view: View) {
        setupToolbar()
    }

    private fun setupToolbar() {
        requireActivity().toolbar.menu.clear()
        requireActivity().toolbar.inflateMenu(R.menu.main_menu)
        requireActivity().toolbar.setOnMenuItemClickListener{
            when (it.itemId){
                R.id.mnu_countries -> {navController.navigate(R.id.countriesDestination)}
            }
            true
        }
    }


}
