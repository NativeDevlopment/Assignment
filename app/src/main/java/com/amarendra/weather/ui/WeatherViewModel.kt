package com.amarendra.weather.ui

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.*

import com.amarendra.todos.network.NetworkService

import kotlinx.coroutines.*
import me.tatarka.bindingcollectionadapter2.ItemBinding
import java.lang.Exception
import androidx.databinding.ObservableBoolean
import com.amarendra.todos.network.WeatherApi
import com.amarendra.todos.ui.main.BaseViewModel
import com.amarendra.weather.BR
import com.amarendra.weather.R
import com.amarendra.weather.network.Forecast

class WeatherViewModel()
 : BaseViewModel() {

     var zipcode: String=""
     var addreessName: MutableLiveData<String> = MutableLiveData()
    var isLoading = ObservableBoolean()
    var isError = ObservableBoolean()
    private var  weatherApi:WeatherApi = NetworkService.createService(WeatherApi::class.java)
    var forcastList: ObservableList<Forecast> =
        ObservableArrayList<Forecast>()
    var myForecastListBinding=ItemBinding.of<Forecast>{todoListBinding,_,_->
        todoListBinding.set(BR.item,R.layout.item_forcast_list)

    }

    fun onRefresh() {

        getData()    }


    fun getData(){

        isLoading.set(true)
        isError.set(false)
        forcastList.clear()

        viewModelScope.launch  (Dispatchers.IO) {
            try {
               var zipcode=StringBuffer(zipcode).append(",").append("in")
                val response = weatherApi.getWeatherForecast(zipcode.toString())
                when{
                    response.isSuccessful -> {
                       withContext(Dispatchers.Main){
                           forcastList.addAll(response.body()?.forecasts!!)
                           isLoading.set(false)

                       }
                    }
                    else->{
                        isError.set(true)
                        isLoading.set(false)

                    }
                }
            }catch (exception : Exception){
                isError.set(true)
                Log.e("PostDataSource", "Failed to fetch data!")
                isLoading.set(false)

            }
        }
    }






}
