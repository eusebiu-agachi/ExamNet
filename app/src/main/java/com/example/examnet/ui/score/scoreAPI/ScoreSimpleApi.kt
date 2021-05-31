package com.example.examnet.ui.score.scoreAPI

import com.example.examnet.ui.score.scoreModel.ScorePost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ScoreSimpleApi {
    @POST("http://89.137.141.228:8080/user/score")
    suspend fun pushPost(@Body post : ScorePost): Response<Int>
}