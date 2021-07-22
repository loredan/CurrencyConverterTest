package ru.loredan13.currencyconvertertest.presentation

import io.reactivex.rxjava3.core.Flowable
import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeRate
import ru.loredan13.currencyconvertertest.domain.GetExchangeRateUseCase
import ru.loredan13.currencyconvertertest.room.ExchangeRateDataSourceImpl
import javax.inject.Inject

class GetExchangeRateUseCaseImpl @Inject constructor(private val exchangeRateDataSource: ExchangeRateDataSourceImpl) :
    GetExchangeRateUseCase {
    override fun getExchangeRate(from: Currency, to: Currency): Flowable<ExchangeRate> =
        exchangeRateDataSource.getExchangeRate(from, to)
}