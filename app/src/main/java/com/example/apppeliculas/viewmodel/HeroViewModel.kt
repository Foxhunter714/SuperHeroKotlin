package com.example.apppeliculas.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.apppeliculas.model.Repository

public class HeroViewModel(application: Application): AndroidViewModel(application) {
    private var repository: Repository = Repository(application)
    var listHero = repository.listHero
    init {
        repository.loadApiData()

    }
}
