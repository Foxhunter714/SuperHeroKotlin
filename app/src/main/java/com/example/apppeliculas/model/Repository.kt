package com.example.apppeliculas.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.apppeliculas.RetrofitClient
import com.example.apppeliculas.model.db.DaoHero
import com.example.apppeliculas.model.db.HeroDatabase
import com.example.apppeliculas.model.db.HeroEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Repository(context: Context) {

    var heroDatabase = HeroDatabase.getDatabase(context)
    var listHero = heroDatabase.getHeroDao().getMinimalHero()
    fun loadApiData() {
        val call = RetrofitClient.retrofitInstance().listHero()



        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                Log.d("Adapter", "${response.code()}")
                Log.d("Adapter", "${response.body()}")
                saveDatabase(heroConverter(response.body()!!))
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.d("Adapter", "Error al cargar peliculas $t")
            }
        })
    }
    fun heroConverter(listHero:List<Hero>): List<HeroEntity>{
        return listHero.map{ hero -> HeroEntity(hero.id, hero.name, hero.powerstats, hero.slug, hero.images)}
    }

    fun saveDatabase(listHeroEntity: List<HeroEntity>){
       CoroutineScope(Dispatchers.IO).launch {heroDatabase.getHeroDao().insertHero(listHeroEntity)}
    }
}