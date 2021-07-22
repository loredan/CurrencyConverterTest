package ru.loredan13.currencyconvertertest.domain

interface FetchExchangeRatesUseCase {
    suspend fun fetchExchangeRates(): List<ExchangeRate>
}