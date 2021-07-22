package ru.loredan13.currencyconvertertest.domain

import io.reactivex.rxjava3.core.Flowable

interface GetExchangeRateUseCase {
    fun getExchangeRate(from: Currency, to: Currency): Flowable<ExchangeRate>
}