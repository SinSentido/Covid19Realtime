package com.example.covid19realtime.ui.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.covid19realtime.R
import com.example.covid19realtime.database.CoronaApi
import com.example.covid19realtime.pojos.Country
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.countries_fragment.*

class CountriesFragment : Fragment(R.layout.countries_fragment), CountriesAdapter.OnItemClickListener {

    private val navController: NavController by lazy {
        findNavController()
    }

    private val listAdapter: CountriesAdapter = CountriesAdapter().also {
        it.setOnItemClickListener(this)
    }

    private val viewModel: CountriesViewModel by viewModels {
        CountriesViewModelFactory(CoronaApi.coronaApiService)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        loadData()
        setupToolbar()
        setupRecyclerView()
        setupSearchBar()
    }

    private fun setupSearchBar() {
        countries_search.addTextChangedListener{ filterList(countries_search.text.toString()) }
    }

    private fun filterList(countryName: String) {
        listAdapter.submitData(viewModel.filterCountries(countryName))
    }

    private fun setupToolbar() {
        requireActivity().toolbar.menu.clear()
    }

    private fun setupRecyclerView() {
        lst_countries.setHasFixedSize(true)
        lst_countries.layoutManager = LinearLayoutManager(context)
        lst_countries.itemAnimator = DefaultItemAnimator()
        lst_countries.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        lst_countries.adapter = listAdapter
    }

    private fun loadData(){
        viewModel.getAllCountries()
        viewModel.countriesObserve.observe(viewLifecycleOwner){
            listAdapter.submitData(it)
        }
    }

    override fun onClick(country: Country) {
        navController.navigate(R.id.countryDestination, bundleOf(getString(R.string.country_name_argument) to country.country))
    }

}
