package com.ereldev.mcureleasedates.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ereldev.mcureleasedates.android.common.ui.MCUReleaseDatesTheme
import com.ereldev.mcureleasedates.android.detail.ui.DETAIL_SCREEN_NAME
import com.ereldev.mcureleasedates.android.detail.ui.DetailScreen
import com.ereldev.mcureleasedates.android.list.ui.ListScreen
import com.ereldev.mcureleasedates.android.list.ui.LIST_SCREEN_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MCUReleaseDatesTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = LIST_SCREEN_NAME) {
                    composable(LIST_SCREEN_NAME) {
                        ListScreen(hiltViewModel(), navController)
                    }
                    composable(DETAIL_SCREEN_NAME) {
                        DetailScreen(hiltViewModel())
                    }
                }
            }
        }
    }
    
}
