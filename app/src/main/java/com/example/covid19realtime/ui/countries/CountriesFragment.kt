package com.example.covid19realtime.ui.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.covid19realtime.R
import kotlinx.android.synthetic.main.countries_fragment.*

class CountriesFragment : Fragment(R.layout.countries_fragment) {

    private val navController: NavController by lazy {
        findNavController()
    }

    val listAdapter: CountriesAdapter = CountriesAdapter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        lst_countries.setHasFixedSize(true)
        lst_countries.layoutManager = LinearLayoutManager(context)
        lst_countries.itemAnimator = DefaultItemAnimator()
        lst_countries.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        lst_countries.adapter = listAdapter
    }

}
