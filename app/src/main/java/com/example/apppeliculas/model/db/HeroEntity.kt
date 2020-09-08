package com.example.apppeliculas.model.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apppeliculas.model.*

@Entity(tableName= "hero_table")
data class HeroEntity(
    @PrimaryKey val id: Int,
    val name : String,
    @Embedded(prefix = "ps_") val powerstats: Powerstats,
    val slug: String,
    @Embedded(prefix = "images_") val images : Images
    //@Embedded(prefix = "wr_") val work: Work,
    //@Embedded(prefix = "bio_") val biography: Biography,
    //@Embedded(prefix = "conn_") val connections: Connections
)

