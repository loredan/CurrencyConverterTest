package ru.loredan13.currencyconvertertest.domain

enum class Currency {
    RUB, USD, EUR, GBP, CHF, CNY;

    override fun toString(): String = name
}