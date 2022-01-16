package com.example.freegamelistapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.freegamelistapp.presentation.free_games_list.component.FreeGamesScreen
import com.example.freegamelistapp.presentation.ui.theme.FreeGameListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeGameListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    FreeGamesScreen()

                }
            }
        }
    }
}
