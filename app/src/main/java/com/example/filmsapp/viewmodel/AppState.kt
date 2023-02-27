package com.example.filmsapp.viewmodel

sealed class AppState {
    data class Loading(val process: Int): AppState()
    data class Success(val filmsData: Any): AppState()
    data class Error(val error: Throwable): AppState()
}