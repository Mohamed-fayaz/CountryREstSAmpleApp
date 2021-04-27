package com.example.countryrest

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
@BindingAdapter("setPopulation")
fun TextView.setTitleText(item : CountryProperty){
    item.let {
        text = it.population.toString()
    }

}