package com.example.cityapp.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cityapp.adapters.City

class CityViewModel(app: Application): AndroidViewModel(app) {

    var cityList= MutableLiveData<List<City>>()
    lateinit var hideBtnNextPage : MutableLiveData<Boolean>

    init {
        cityList.value = Repository.cityList
        hideBtnNextPage.value = true
    }

}