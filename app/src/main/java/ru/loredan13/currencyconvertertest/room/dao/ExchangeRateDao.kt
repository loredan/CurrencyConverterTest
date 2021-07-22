package ru.loredan13.currencyconvertertest.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Flowable
import ru.loredan13.currencyconvertertest.room.model.ExchangeRateEntity

@Dao
interface ExchangeRateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg rates: ExchangeRateEntity)

    @Query("SELECT * FROM ExchangeRate WHERE `from` == :from AND `to` == :to")
    fun getExchangeRate(from: String, to: String): Flowable<ExchangeRateEntity>
}