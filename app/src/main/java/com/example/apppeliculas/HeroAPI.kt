package com.example.apppeliculas

import retrofit2.Call
import retrofit2.http.GET

interface HeroAPI {
    @GET("superhero-api/api")
    fun allHero(): Call<ListHero>
}