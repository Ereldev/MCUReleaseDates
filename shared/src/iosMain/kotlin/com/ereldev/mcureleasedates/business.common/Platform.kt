package com.ereldev.mcureleasedates.business.common

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

actual class Platform actual constructor() {
    actual val language: String = NSLocale.currentLocale.languageCode
}