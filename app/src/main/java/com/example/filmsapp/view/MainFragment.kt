package com.example.filmsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentMainBinding


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
    }
    private val ui get() = _ui!!

    override fun onDestroyView() {
        super.onDestroyView()
        _ui = null
    }
}