package ru.loredan13.currencyconvertertest.room

import io.reactivex.rxjava3.core.Flowable
import ru.loredan13.currencyconvertertest.data.ExchangeRateDataSource
import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeRate
import ru.loredan13.currencyconvertertest.room.dao.ExchangeRateDao
import ru.loredan13.currencyconvertertest.room.model.toRoomEntity
import javax.inject.Inject

class ExchangeRateDataSourceImpl @Inject constructor(private val exchangeRateDao: ExchangeRateDao) : ExchangeRateDataSource {
    override fun getExchangeRate(from: Currency, to: Currency): Flowable<ExchangeRate> =
        exchangeRateDao.getExchangeRate(from.name, to.name).map { it.toDomainModel() }

    override suspend fun putExchangeRates(rates: List<ExchangeRate>) {
        exchangeRateDao.insert(*rates.map { it.toRoomEntity() }.toTypedArray())
    }
}