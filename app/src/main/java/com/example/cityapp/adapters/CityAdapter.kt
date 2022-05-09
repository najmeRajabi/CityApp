package com.example.cityapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cityapp.R

typealias ClickHandler = (city: City) -> Unit

class CityAdapter(var clickHandler : ClickHandler):
    ListAdapter<City, CityAdapter.ViewHolder>(CityDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_item_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position) , clickHandler )


    }

    object CityDiffCallback : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.id == newItem.id
        }
    }


    class ViewHolder( view: View): RecyclerView.ViewHolder(view) {




        fun bind(
            city: City,
            clickHandler: ClickHandler
        ) {


        }
    }

}