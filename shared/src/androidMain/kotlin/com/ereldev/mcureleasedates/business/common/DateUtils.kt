package com.ereldev.mcureleasedates.business.common

import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

actual class DateUtils {

    actual companion object {

        actual fun formatDate(input: String): String {
            return try {
                val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)

                return inputFormatter.parse(input)?.run {
                    dateFormatter.format(this)
                } ?: input
            } catch (e: Exception) { input }
        }

        actual fun nowMinusOneMonth(): String {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

            val date = Calendar.getInstance().apply {
                add(Calendar.MONTH, -1)
            }

            return formatter.format(date.time)
        }

    }

}