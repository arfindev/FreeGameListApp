package com.example.freegamelistapp.domain.use_cases

import com.example.freegamelistapp.common.Resource
import com.example.freegamelistapp.data.remote.dto.toFreeGames
import com.example.freegamelistapp.domain.model.FreeGames
import com.example.freegamelistapp.domain.repository.FreeGamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class FreeGamesUseCase @Inject constructor(private val repository: FreeGamesRepository) {
    operator fun invoke(): Flow<Resource<List<FreeGames>>> = flow {
        try {
            emit(Resource.Loading<List<FreeGames>>())
            val games = repository.getFreeGames().map { it.toFreeGames() }
            emit(Resource.Success<List<FreeGames>>(games))
        } catch (e: HttpException) {
            emit(Resource.Error<List<FreeGames>>(e.localizedMessage ?: "An unexpected Error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error<List<FreeGames>>("Could not reach the server. Check your internet connection"))

        }
    }
}