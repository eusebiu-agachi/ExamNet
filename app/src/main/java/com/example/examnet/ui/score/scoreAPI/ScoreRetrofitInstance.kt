package com.example.examnet.ui.score.scoreAPI

import com.example.examnet.ui.score.scoreUtil.ScoreConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScoreRetrofitInstance {

    companion object {
        const val BASE_URL = "http://89.137.141.228:8080/user/score"
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(ScoreConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: ScoreSimpleApi by lazy {
            retrofit.create(ScoreSimpleApi::class.java)
        }
    }
}