package com.ereldev.mcureleasedates.android.common.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val RedColor = Color(0xFFED1D24)
private val DarkRedColor = Color(0xFF940409)

@Composable
fun MCUReleaseDatesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    val lightColors = lightColors(
        primary = RedColor
    )

    val darkColors = darkColors(
        primary = RedColor
    )

    systemUiController.setSystemBarsColor(DarkRedColor)

    MaterialTheme(
        colors = if (darkTheme) darkColors else lightColors,
        content = content
    )
}