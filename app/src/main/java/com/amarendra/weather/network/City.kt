package com.amarendra.weather.network

import com.google.gson.annotations.SerializedName


data class City(
        val id: Integer,
        val name: String,
        @SerializedName(OpenWeatherJsonKeys.OWM_COORD)
        val coordinates: Coordinates,
        val country: String
)

data class Coordinates(
        @SerializedName(OpenWeatherJsonKeys.OWM_LONGITUDE)
        val longitude: Double,
        @SerializedName(OpenWeatherJsonKeys.OWM_LATITUDE)
        val latitude: Double
)