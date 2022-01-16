package com.example.freegamelistapp.domain.repository

import com.example.freegamelistapp.data.remote.dto.FreeGamesDto

interface FreeGamesRepository {
    suspend fun getFreeGames(): List<FreeGamesDto>
}