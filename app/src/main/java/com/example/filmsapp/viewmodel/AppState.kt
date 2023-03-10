package com.example.filmsapp.viewmodel

import com.example.filmsapp.model.Film

sealed class AppState {
    data class Loading(val process: Int): AppState()
    data class Success(val filmsData: Film): AppState()
    data class Error(val error: Throwable): AppState()
}