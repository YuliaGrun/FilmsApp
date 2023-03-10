package com.example.filmsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmsapp.model.RepositoryImpl

class MainViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData(),
                    private val repositoryImpl: RepositoryImpl = RepositoryImpl()): ViewModel(){
    fun getData(): LiveData<AppState> {
        return liveData
    }
    fun getFilmsFromSource() = getFilms()

    private fun getFilms(){
        liveData.postValue(AppState.Loading(process = 0))
        Thread{
            Thread.sleep(2000L)
            liveData.postValue(AppState.Success(repositoryImpl.getListFilms()))
        }.start()
    }
}