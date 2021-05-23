package com.example.examnet.ui.register.registerRepository

import com.example.examnet.ui.register.registerApi.registerRetrofitInstance
import com.example.examnet.ui.register.registerModel.registerPost
import retrofit2.Response

class rgstrRepository {

    suspend fun pushPost(post : registerPost): Response<Int> {
        return registerRetrofitInstance.api.pushPost(post)
    }
}