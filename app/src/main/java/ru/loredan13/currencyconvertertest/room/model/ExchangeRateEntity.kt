package ru.loredan13.currencyconvertertest.room.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.loredan13.currencyconvertertest.room.BigDecimalConverter
import java.math.BigDecimal

@Entity(tableName = "ExchangeRate", indices = [Index(value = ["from", "to"], unique = true)])
@TypeConverters(BigDecimalConverter::class)
data class ExchangeRateEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val from: String,
    val to: String,
    val rate: BigDecimal
) {
    fun toDomainModel() = ru.loredan13.currencyconvertertest.domain.ExchangeRate(from, to, rate)
}

fun ru.loredan13.currencyconvertertest.domain.ExchangeRate.toRoomEntity() =
    ExchangeRateEntity(from = from, to = to, rate = rate)