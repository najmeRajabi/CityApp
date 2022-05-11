package com.example.cityapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cityapp.adapters.City

object Repository {

    val cityList : List<City> = listOf(
        City(1 , "isfahan" ),
        City(2 , "shiraz" ),
        City(3 , "mashhad" ),
        City(4 , "ahvaz" ),
        City(5 , "yazd" ),
        City(6 , "ghom" ),
        City(7 , "rasht" ),
        City(8 , "aran" ),
        City(9 , "bojnord" ),
        City(10 , "tehran" )
    )
    val selectedCityList : ArrayList<City> = arrayListOf()
}