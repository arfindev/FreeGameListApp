package com.example.freegamelistapp.presentation.free_games_list

import com.example.freegamelistapp.domain.model.FreeGames

data class FreeGamesState(
    val isLoading: Boolean = false,
    val gameList: List<FreeGames>  = emptyList(),
    val error: String = ""
)