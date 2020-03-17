package com.example.covid19realtime.ui.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19realtime.R
import com.example.covid19realtime.dataClasses.Country
import kotlinx.android.extensions.LayoutContainer

class CountriesAdapter: RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    var countries: List<Country> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater:  LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.coutries_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //var country = countries[position]
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    }

}