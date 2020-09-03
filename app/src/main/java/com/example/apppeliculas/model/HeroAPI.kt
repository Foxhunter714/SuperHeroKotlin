package com.example.apppeliculas.model

import com.example.apppeliculas.model.Hero
import retrofit2.Call
import retrofit2.http.GET

interface HeroAPI {
    @GET("all.json")
    fun listHero(): Call<List<Hero>>
    }