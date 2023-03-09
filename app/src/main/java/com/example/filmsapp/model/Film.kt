package com.example.filmsapp.model

import com.example.filmsapp.R

data class Film (val filmName: String, val yearRelease: Int, val country: String, val pictureId: Int)

fun getFilms(): List<Film> {
    return listOf(
        Film("Top Gun: Maverick", 2022, "United States", R.drawable.ic_launcher_foreground),
        Film("Avatar: The Way of Water", 2022, "United States", R.drawable.ic_launcher_foreground),
        Film("Black Panther: Wakanda Forever", 2022, "United States", R.drawable.ic_launcher_foreground),
        Film("Doctor Strange in the Multiverse of Madness", 2022, "United States", R.drawable.ic_launcher_foreground),
        Film("Jurassic World Dominion", 2022, "United States", R.drawable.ic_launcher_foreground)

    )
}