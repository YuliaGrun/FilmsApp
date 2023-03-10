package com.example.filmsapp.model

class RepositoryImpl: Repository {
    override fun getListFilms(): List<Film> {
        return getFilms()
    }
    override fun getFilm(): Film {
        return getOneFilm()
    }
}