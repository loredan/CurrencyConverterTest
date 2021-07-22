package ru.loredan13.currencyconvertertest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ExchangeRatesClient @Inject constructor() {
    val service = Retrofit.Builder()
        .baseUrl("http://api.exchangeratesapi.io/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ExchangeRatesService::class.java)

    companion object {

    }
}