package com.ereldev.mcureleasedates.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ereldev.mcureleasedates.Greeting
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.mcureleasedates.android.common.ui.MCUReleaseDatesTheme

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MCUReleaseDatesTheme {
                GreatText(greet())
            }
        }
    }
    
}

@Composable
fun GreatText(text: String) {
    Text(text)
}

@Preview
@Composable
fun GreatTextPreview() {
    MCUReleaseDatesTheme {
        GreatText(greet())
    }
}