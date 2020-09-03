package com.example.apppeliculas.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoHero {
    //Guarda y recupera informacion desde la entidad
    @Query("SELECT * FROM hero_table")
    fun getAllHero() : LiveData<List<HeroEntity>>

    @Insert
    suspend fun insertHero(heroList: List<HeroEntity>)
    //fun insertHero(hero: HeroEntity)


}