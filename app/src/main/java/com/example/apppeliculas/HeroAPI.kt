package com.example.apppeliculas

import retrofit2.Call
import retrofit2.http.GET

interface HeroAPI {
    @GET("/all.json")
    fun allHero(): Call<ListHero>
    @GET("/id/i.json")
    fun allHeroByID(): Call<ListHero>
    @GET("/powerstats/1.json")
    fun allPowerstatsByHero(): Call<Powerstats>
    @GET("/appearance/1.json")
    fun allAppearanceByHero(): Call<Appearance>
    @GET("/biography/1.json")
    fun allBiographyByHero(): Call<Biography>
    @GET("/connections/1.json")
    fun allConnectionsByHero(): Call<Connections>
    @GET("/work/1.json")
    fun allWorkByHero(): Call<Work>
    @GET("/images/xs/1-a-bomb.jpg")
    fun allThumbByHero(): Call<Images>
    @GET("/images/sm/1-a-bomb.jpg")
    fun allSmallImageByHero(): Call<Images>
    @GET("/images/md/1-a-bomb.jpg")
    fun allMediumImagesByHero(): Call<Images>
    @GET("/images/lg/1-a-bomb.jpg")
    fun allLargeImageByHero(): Call<Images>

}