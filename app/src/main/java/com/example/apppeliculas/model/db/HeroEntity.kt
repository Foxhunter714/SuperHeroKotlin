package com.example.apppeliculas.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apppeliculas.model.Images
import com.example.apppeliculas.model.Powerstats

@Entity(tableName= "hero_table")
data class HeroEntity(
    @PrimaryKey val id: Int,
    val name : String,
    @Embedded(prefix = "ps_") val powerstats: Powerstats,
    val slug: String,
    @Embedded(prefix = "images_") val images : Images
)

