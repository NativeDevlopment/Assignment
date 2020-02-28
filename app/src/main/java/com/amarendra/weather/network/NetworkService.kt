package com.amarendra.todos.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    var logging   = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    var client : OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

    private var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    public fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

    private val weatherApi = retrofit.create(WeatherApi::class.java)




}