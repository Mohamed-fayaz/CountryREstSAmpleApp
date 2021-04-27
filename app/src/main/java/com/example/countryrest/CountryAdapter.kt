package com.example.countryrest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countryrest.databinding.RecyclerviewBinding

class  CountryAdapter(): ListAdapter<CountryProperty, CountryAdapter.CountryViewHolder>(DiffCallback) {
    object DiffCallback : DiffUtil.ItemCallback<CountryProperty>(){
        override fun areItemsTheSame(oldItem: CountryProperty, newItem: CountryProperty): Boolean {
            return oldItem ==newItem
        }

        override fun areContentsTheSame(oldItem: CountryProperty, newItem: CountryProperty): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.CountryViewHolder {
        return CountryViewHolder(RecyclerviewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)


    }
    class CountryViewHolder(private var binding: RecyclerviewBinding):

        RecyclerView.ViewHolder(binding.root) {
        fun bind(countryProperty: CountryProperty) {
            binding.property = countryProperty
            binding.executePendingBindings()
        }
    }


}