package ru.loredan13.currencyconvertertest.retrofit

import ru.loredan13.currencyconvertertest.BuildConfig
import ru.loredan13.currencyconvertertest.data.ExchangeRatesDataSource
import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeRate
import javax.inject.Inject

class ExchangeRatesDataSourceImpl @Inject constructor(private val exchangeRatesService: ExchangeRatesService) :
    ExchangeRatesDataSource {
    override suspend fun fetchExchangeRates(): List<ExchangeRate> =
        exchangeRatesService.getLatestRates(
            BuildConfig.ACCESS_KEY,
            Currency.values().toList().joinToString(separator = ",") { it.name }
        ).toDomainModels()
}