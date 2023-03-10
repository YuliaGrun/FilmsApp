package com.example.filmsapp.model

interface Repository {
    fun getListFilms():List<Film>
    fun getFilm(): Film
}