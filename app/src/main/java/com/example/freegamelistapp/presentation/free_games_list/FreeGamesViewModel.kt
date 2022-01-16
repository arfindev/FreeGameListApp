package com.example.freegamelistapp.presentation.free_games_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegamelistapp.common.Resource
import com.example.freegamelistapp.domain.use_cases.FreeGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class freeGamesViewModel @Inject constructor(
    private val freeGamesUseCase: FreeGamesUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(FreeGamesState())
    val state: State<FreeGamesState> = _state

    init {
        getGames()
    }


    private fun getGames() {
        freeGamesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FreeGamesState(gameList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        FreeGamesState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = FreeGamesState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }


}