package com.example.apppeliculas

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.themoviedb.org"

class RetrofitClient {
    companion object{
        fun retrofitInstance(): HeroAPI{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return  retrofit.create(HeroAPI::class.java)
        }
    }
}
