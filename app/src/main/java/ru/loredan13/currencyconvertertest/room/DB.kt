package ru.loredan13.currencyconvertertest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.loredan13.currencyconvertertest.room.dao.ExchangeRateDao
import ru.loredan13.currencyconvertertest.room.model.ExchangeRateEntity

@Database(entities = [ExchangeRateEntity::class], version = 1)
abstract class DB : RoomDatabase() {
    abstract fun exchangeRateDao(): ExchangeRateDao
}