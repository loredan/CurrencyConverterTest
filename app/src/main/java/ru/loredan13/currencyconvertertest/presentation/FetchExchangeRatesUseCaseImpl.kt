package ru.loredan13.currencyconvertertest.presentation

import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeRate
import ru.loredan13.currencyconvertertest.domain.FetchExchangeRatesUseCase
import ru.loredan13.currencyconvertertest.retrofit.ExchangeRatesDataSourceImpl
import javax.inject.Inject

class FetchExchangeRatesUseCaseImpl @Inject constructor(private val exchangeRatesDataSource: ExchangeRatesDataSourceImpl) :
    FetchExchangeRatesUseCase {
    override suspend fun fetchExchangeRates(): List<ExchangeRate> =
        exchangeRatesDataSource.fetchExchangeRates()
}