package com.example.cityapp.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cityapp.adapters.City

class CityViewModel(app: Application): AndroidViewModel(app) {

    var cityList= MutableLiveData<List<City>>()
    var selectedCityList= MutableLiveData<List<City>>()
    var hideBtnNextPage = MutableLiveData<Boolean>()
    var selectedItem = MutableLiveData<Boolean>()

//    val hideBtnNextPage = Transformations.map(selectedCityList){
//        it.isEmpty()
//    }

    init {
        cityList.value = Repository.cityList
        selectedItem.value = false
        hideBtnNextPage.value = true
    }

    fun selectItem(city: City){
        city.selected = !city.selected
        if (city.selected){
            selectedCityList.value?.plus(city)
            hideBtnNextPage.value = false
        }else{
            selectedCityList.value?.minus(city)
            checkHiddenNextBtn()
        }
    }

    private fun checkHiddenNextBtn() {
        hideBtnNextPage.value = selectedCityList.value?.isEmpty() == true
    }

}