package com.amarendra.todos.network

import com.amarendra.weather.network.OpenWeatherMapResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface WeatherApi {
    @GET("forecast")
    suspend fun getWeatherForecast(@Query("zip") zipcode:String, @Query("appid") appId:String="426108da72ebea353026930f5e0ab8db") : Response<OpenWeatherMapResponse>
}