package com.ereldev.mcureleasedates.android.common.ui

import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String {
    return try {
        val inputFormatter = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
        val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)

        return inputFormatter.parse(this)?.run {
            dateFormatter.format(this)
        } ?: this
    } catch (e: Exception) { this }
}