package com.example.mytestwork.api.dailymotion

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DailymotionApi {
    @GET("/users")
    suspend fun getUsers(): UserDailymotion

    companion object {
       private var retrofitService: DailymotionApi? = null

        fun getInstance() : DailymotionApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.dailymotion.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(DailymotionApi::class.java)
            }
            return retrofitService!!
        }
    }
}