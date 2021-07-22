package ru.loredan13.currencyconvertertest.domain

import io.reactivex.rxjava3.subjects.BehaviorSubject

abstract class ExchangeInteractor : GetExchangeRateUseCase {
    var currencyFrom = BehaviorSubject.create<Currency>()
    var currencyTo = BehaviorSubject.create<Currency>()
}