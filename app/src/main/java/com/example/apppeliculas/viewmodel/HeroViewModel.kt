package com.example.apppeliculas.viewmodel

import android.app.Application
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.apppeliculas.model.Repository
import com.example.apppeliculas.model.db.HeroEntity
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry

public class HeroViewModel(application: Application): AndroidViewModel(application) {
    private var repository: Repository = Repository(application)
    var listHero = repository.listHero

    //var listStats = repository.listStats
    init {
        repository.loadApiData()

    }

    fun getDetails(param1: String): LiveData<HeroEntity> {
        return repository.getDetails(param1)
    }
}
