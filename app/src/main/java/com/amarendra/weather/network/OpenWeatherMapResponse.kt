package com.amarendra.weather.network

import android.content.ContentValues
import com.amarendra.weather.utils.DateUtils
import com.google.gson.annotations.SerializedName
import org.jetbrains.anko.collections.forEachWithIndex

/**
 * Created by enrico on 1/18/18.
 */
data class OpenWeatherMapResponse(
        val city: City,
        @SerializedName(OpenWeatherJsonKeys.OWM_MESSAGE_CODE)
        val messageCode: Int,
        @SerializedName(OpenWeatherJsonKeys.OWM_COUNT)
        val count: Int,
        @SerializedName(OpenWeatherJsonKeys.OWM_LIST)
        val forecasts: List<Forecast>
) {
    fun fixDates() {
        val normalizedUtcStartDay = DateUtils.getNormalizedUtcDateForToday()
        forecasts.forEachWithIndex { i, forecast ->
            val dateTimeMillis = normalizedUtcStartDay + DateUtils.DAY_IN_MILLIS * i
            forecast.date = dateTimeMillis
        }
    }


}