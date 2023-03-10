package com.example.filmsapp.view.main.film

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentFilmBinding
import com.example.filmsapp.model.Film

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FilmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var _ui: FragmentFilmBinding? = null

    private val ui get() = _ui!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _ui = FragmentFilmBinding.inflate(inflater, container, false)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var film: Film? = null
        film = if (Build.VERSION.SDK_INT >= 33) {
            arguments?.getParcelable(BUNDLE_EXTRA, Film::class.java)
        }else
            arguments?.getParcelable<Film>(BUNDLE_EXTRA)

        if(film != null){
            ui.imageViewFilm.setImageResource(film.pictureId)
            ui.nameViewFilm.text = film.filmName
            ui.yearViewFilm.text = film.yearRelease.toString()
        }



    }

    companion object {
        const val BUNDLE_EXTRA = "film"
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(bundle: Bundle): FilmFragment {
            val fragment = FilmFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}