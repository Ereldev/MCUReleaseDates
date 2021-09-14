package com.ereldev.mcureleasedates.business.common

import java.util.*

actual class Platform actual constructor() {
    actual val language: String = Locale.getDefault().language
}