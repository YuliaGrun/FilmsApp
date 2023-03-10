package com.example.filmsapp.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.R
import com.example.filmsapp.model.Film
import org.w3c.dom.Text

class MainFragmentAdapter(private var onItemViewClickListener: MainFragment.OnItemViewClickListener?) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var filmsData: List<Film> = listOf()

    fun setFilms(data: List<Film>){
        filmsData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragmentAdapter.MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_main_item, parent, false) as View)
    }

    override fun onBindViewHolder(holder: MainFragmentAdapter.MainViewHolder, position: Int) {
       holder.bind(filmsData[position])
    }

    override fun getItemCount(): Int {
       return filmsData.size
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         fun bind(film: Film){
             itemView.findViewById<TextView>(R.id.nameViewFilm).text = film.filmName
             itemView.setOnClickListener {
                 onItemViewClickListener?.onItemViewClick(film)
             }
         }
    }
}