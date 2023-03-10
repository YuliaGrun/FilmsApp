package com.example.filmsapp.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.filmsapp.databinding.FragmentMainBinding
import com.example.filmsapp.model.Film
import com.example.filmsapp.viewmodel.AppState
import com.example.filmsapp.viewmodel.MainViewModel


class MainFragment : Fragment() {
    private var _ui:FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _ui = FragmentMainBinding.inflate(inflater, container,false)
        val view = _ui!!.root
        return view

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel  = ViewModelProvider(this)[MainViewModel::class.java]
        val observer = object : Observer<AppState> {
            override fun onChanged(data: AppState) {
                renderData(data)
            }
        }
        viewModel.getData().observe(viewLifecycleOwner,observer)
        viewModel.getFilmsFromSource()
    }


    private val ui get() = _ui!!

    override fun onDestroyView() {
        super.onDestroyView()
        _ui = null
    }
    private fun renderData(data: AppState){
        when(data){
            is AppState.Error -> {
                _ui!!.loadingLayout.visibility = View.GONE
            }
            is AppState.Loading -> {
                _ui!!.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                _ui!!.loadingLayout.visibility = View.GONE
                val filmData = data.filmsData
                setData(filmData)
            }
        }
    }

    private fun setData(film: Film){
        _ui!!.imageViewFilm.setImageResource(film.pictureId)
        _ui!!.nameViewFilm.text = film.filmName
        _ui!!.yearViewFilm.text = film.yearRelease.toString()
    }
}