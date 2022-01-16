package com.example.freegamelistapp.data.remote

import com.example.freegamelistapp.data.remote.dto.FreeGamesDto
import retrofit2.http.GET

interface FreeGamesApi {
    @GET("/api/games")
    suspend fun getFreeGames(): List<FreeGamesDto>
}