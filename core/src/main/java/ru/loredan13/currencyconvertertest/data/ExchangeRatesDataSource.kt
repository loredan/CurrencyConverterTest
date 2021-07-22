package ru.loredan13.currencyconvertertest.data

import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeRate

interface ExchangeRatesDataSource {
    suspend fun fetchExchangeRates(): List<ExchangeRate>
}