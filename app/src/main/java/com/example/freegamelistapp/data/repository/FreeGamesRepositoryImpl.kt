package com.example.freegamelistapp.data.repository

import com.example.freegamelistapp.data.remote.FreeGamesApi
import com.example.freegamelistapp.data.remote.dto.FreeGamesDto
import com.example.freegamelistapp.domain.repository.FreeGamesRepository
import javax.inject.Inject

class FreeGamesRepositoryImpl @Inject constructor(
    private val api: FreeGamesApi,
) : FreeGamesRepository {
    override suspend fun getFreeGames(): List<FreeGamesDto> {
        return api.getFreeGames()
    }
}