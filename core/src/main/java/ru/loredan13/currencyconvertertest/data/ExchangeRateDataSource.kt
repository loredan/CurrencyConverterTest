package ru.loredan13.currencyconvertertest.data

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeRate

interface ExchangeRateDataSource {
    fun getExchangeRate(from: Currency, to: Currency): Flowable<ExchangeRate>

    suspend fun putExchangeRates(rates: List<ExchangeRate>)
}