package com.example.cityapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

//    fun removeItem(position: Int) {
//        imageModelArrayList.removeAt(position)
//        notifyItemRemoved(position)
//        notifyItemRangeChanged(position, imageModelArrayList.size)
//    }
//
//    fun restoreItem(model: Model, position: Int) {
//        imageModelArrayList.add(position, model)
//        // notify item added by position
//        notifyItemInserted(position)
//    }


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        val txvCity = view.findViewById<TextView>(R.id.txv_city_name)
        val imvSelected = view.findViewById<ImageView>(R.id.imv_select)


        fun bind(
            city: City,
            clickHandler: ClickHandler
        ) {

            txvCity.text = city.name
            changeBackground(city)

            view.setOnClickListener {
                clickHandler(city)
                changeBackground(city)
            }
        }


        private fun changeBackground(city: City) {
            if (city.selected){
                view.setBackgroundResource(R.color.selected_bg)
                imvSelected.visibility = View.VISIBLE
            }else{
                view.setBackgroundResource(R.color.unselected_bg)
                imvSelected.visibility = View.INVISIBLE
            }

        }
    }

}