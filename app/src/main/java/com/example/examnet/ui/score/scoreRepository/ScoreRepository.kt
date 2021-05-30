package com.example.examnet.ui.score.scoreRepository

import com.example.examnet.ui.score.scoreAPI.ScoreRetrofitInstance
import com.example.examnet.ui.score.scoreModel.ScorePost
import retrofit2.Response

class ScoreRepository {

    suspend fun pushPost(post : ScorePost): Response<String> {
        return ScoreRetrofitInstance.api.pushPost(post)
    }
}