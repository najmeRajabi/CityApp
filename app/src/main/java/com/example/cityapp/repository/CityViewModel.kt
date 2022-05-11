package com.example.cityapp.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cityapp.adapters.City

class CityViewModel(app: Application): AndroidViewModel(app) {

    var cityList= MutableLiveData<List<City>>()
    var selectedCityList= MutableLiveData<List<City>>()
    var hideBtnNextPage = MutableLiveData<Boolean>()
    var selectedItem = MutableLiveData<Boolean>()



    init {
        cityList.value = Repository.cityList
        selectedItem.value = false
        hideBtnNextPage.value = true
    }

    fun selectItem(city: City){
        city.selected = !city.selected
        if (city.selected){
            Repository.selectedCityList.add(city)
            selectedCityList.value = Repository.selectedCityList
            checkHiddenNextBtn()
        }else{
            Repository.selectedCityList.remove(city)
            selectedCityList.value = Repository.selectedCityList
            checkHiddenNextBtn()
        }
    }

    private fun checkHiddenNextBtn() {
        hideBtnNextPage.value = selectedCityList.value?.isEmpty() == true
    }

}