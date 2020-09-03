package com.example.apppeliculas.model.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HeroEntity::class], version = 1)
abstract class HeroDatabase : RoomDatabase(){

    abstract fun getHeroDao(): DaoHero

    companion object{
        //singleton prevents multiple instances of database opening at the same time
        @Volatile
        private var INSTANCE: HeroDatabase?= null

        fun getDatabase(context:Context): HeroDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, HeroDatabase::class.java, "hero_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}