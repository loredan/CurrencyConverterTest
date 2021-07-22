package ru.loredan13.currencyconvertertest.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.loredan13.currencyconvertertest.retrofit.model.LatestRatesResponse

interface ExchangeRatesService {
    @GET("latest")
    suspend fun getLatestRates(
        @Query("access_key") accessKey: String,
        @Query("symbols") symbols: String
    ): LatestRatesResponse
}