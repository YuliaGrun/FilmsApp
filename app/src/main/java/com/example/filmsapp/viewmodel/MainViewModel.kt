package com.example.filmsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val liveData: MutableLiveData<AppState> = MutableLiveData()): ViewModel(){

    fun getData(): LiveData<AppState> {
        return liveData
    }

    fun getFilms(){
        Thread{
            liveData.postValue(AppState.Loading(process = 0))
            Thread.sleep(2000L)
            liveData.postValue(AppState.Success(Any()))
        }.start()
    }
}