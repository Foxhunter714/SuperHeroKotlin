package com.example.apppeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apppeliculas.model.Hero
import com.example.apppeliculas.model.Repository
import com.example.apppeliculas.model.db.HeroMini
import com.example.apppeliculas.viewmodel.HeroViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var heroList = ArrayList<HeroMini>()
    private lateinit var adapter: HeroAdapter
    private lateinit var heroViewModel : HeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("tag", "creando")
        adapter = HeroAdapter(heroList)
        heroRecycler.adapter = adapter
        heroViewModel = ViewModelProvider(this).get(HeroViewModel::class.java)
        heroViewModel.listHero.observe(this, Observer{
            adapter.updateItems(it)
        })

    }

}
