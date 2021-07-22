package ru.loredan13.currencyconvertertest.domain

interface InitInteractor {
    abstract suspend fun initExchangeRates()
}