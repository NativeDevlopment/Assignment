package com.amarendra.weather.network

import com.amarendra.weather.utils.DateUtils
import com.google.gson.annotations.SerializedName



data class Forecast (
    var date: Long = DateUtils.getNormalizedUtcDateForToday(),
    @SerializedName(OpenWeatherJsonKeys.OWM_TEMPERATURE_MAIN)
        val temperature: Temp,
    val weather: List<Condition>,
    val wind: Wind,
    val dt_txt:String
) {

}


data class Temp (
        @SerializedName(OpenWeatherJsonKeys.OWM_MIN)
        val min: String,
        @SerializedName(OpenWeatherJsonKeys.OWM_MAX)
        val max: String,
        val pressure: String,
        val humidity: String
)

data class Condition (
        val id: Int
)

data class Wind (
        @SerializedName(OpenWeatherJsonKeys.OWM_WINDSPEED)
        val speed: String,
        @SerializedName(OpenWeatherJsonKeys.OWM_WIND_DIRECTION)
        val direction: String
)