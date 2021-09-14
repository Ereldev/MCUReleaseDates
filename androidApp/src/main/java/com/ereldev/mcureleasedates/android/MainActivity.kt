package com.ereldev.mcureleasedates.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ereldev.mcureleasedates.android.common.ui.MCUReleaseDatesTheme
import com.ereldev.mcureleasedates.android.list.ui.ListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MCUReleaseDatesTheme {
                ListScreen()
            }
        }
    }
    
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun PreviewMainActivity() {
    ListScreen()
}