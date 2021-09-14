package com.ereldev.mcureleasedates.business.common

expect class DateUtils {

    companion object {
        fun formatDate(input: String): String
        fun nowMinusOneMonth(): String
    }

}