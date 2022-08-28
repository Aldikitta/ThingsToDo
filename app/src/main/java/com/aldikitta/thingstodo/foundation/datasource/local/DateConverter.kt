package com.aldikitta.thingstodo.foundation.datasource.local

import androidx.room.TypeConverter
import com.aldikitta.thingstodo.foundation.extension.toLocalDateTime
import com.aldikitta.thingstodo.foundation.extension.toMillis
import java.time.LocalDateTime

class DateConverter {
    @TypeConverter
    fun toDate(date: Long?): LocalDateTime?{
        if (date == null) return null

        return date.toLocalDateTime()
    }

    @TypeConverter
    fun toDateLong(date: LocalDateTime?): Long?{
        if (date == null) return null

        return date.toMillis()
    }
}