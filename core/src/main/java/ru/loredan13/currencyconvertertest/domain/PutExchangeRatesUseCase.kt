package ru.loredan13.currencyconvertertest.domain

interface PutExchangeRatesUseCase {
    suspend fun putExchangeRates(rates: List<ExchangeRate>)
}