package ru.loredan13.currencyconvertertest.presentation

import ru.loredan13.currencyconvertertest.domain.ExchangeRate
import ru.loredan13.currencyconvertertest.domain.PutExchangeRatesUseCase
import ru.loredan13.currencyconvertertest.room.ExchangeRateDataSourceImpl
import javax.inject.Inject

class PutExchangeRatesUseCaseImpl @Inject constructor(private val exchangeRateDataSource: ExchangeRateDataSourceImpl) :
    PutExchangeRatesUseCase {
    override suspend fun putExchangeRates(rates: List<ExchangeRate>) {
        exchangeRateDataSource.putExchangeRates(rates)
    }
}