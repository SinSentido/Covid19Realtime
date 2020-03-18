package com.example.covid19realtime.ui.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.covid19realtime.R
import com.example.covid19realtime.pojos.Country
import com.example.covid19realtime.utils.getCountryCode
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import java.util.*

class CountriesAdapter: RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    var countries: List<Country> = listOf()
    private var onItemClickListener: CountriesAdapter.OnItemClickListener? = null

    fun submitData(newData: List<Country>){
        countries = newData
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: CountriesAdapter.OnItemClickListener){
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater:  LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.countries_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var country = countries[position]
        holder.bind(country)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        val countries_item_img_country: ImageView =
            containerView.findViewById(R.id.countries_item_img_country)
        val countries_item_lbl_name: TextView =
            containerView.findViewById(R.id.countries_item_lbl_name)
        val countries_item_lbl_cases: TextView =
            containerView.findViewById(R.id.countries_item_lbl_cases)
        val countries_item_lbl_recovered: TextView =
            containerView.findViewById(R.id.countries_item_lbl_recovered)
        val countries_item_lbl_deaths: TextView =
            containerView.findViewById(R.id.countries_item_lbl_deaths)

        init {
            containerView.setOnClickListener { onItemClickListener?.onClick(countries[adapterPosition]) }
        }

        fun bind(country: Country) {
            var countryCode: String? = getCountryCode(country.country)

            Glide.with(containerView)
                .load("https://www.countryflags.io/$countryCode/flat/64.png")
                .into(countries_item_img_country)
            countries_item_lbl_name.text = country.country
            countries_item_lbl_cases.text =
                containerView.resources.getString(R.string.countries_item_cases, country.cases)
            countries_item_lbl_recovered.text = containerView.resources.getString(
                R.string.countries_item_recovered,
                country.recovered
            )
            countries_item_lbl_deaths.text =
                containerView.resources.getString(R.string.countries_item_deaths, country.deaths)
        }
    }

    interface OnItemClickListener{
        fun onClick(country: Country)
    }

}