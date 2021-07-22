package ru.loredan13.currencyconvertertest.room

import androidx.room.TypeConverter
import java.math.BigDecimal

object BigDecimalConverter {
    @TypeConverter
    fun fromString(string: String?) = string?.toBigDecimalOrNull()

    @TypeConverter
    fun toString(bigDecimal: BigDecimal?) = bigDecimal?.toString()
}