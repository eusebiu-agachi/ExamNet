package com.example.examnet.ui.register.registerRepository

import com.example.examnet.ui.register.registerApi.RegisterRetrofitInstance
import com.example.examnet.ui.register.registerModel.RegisterPost
import retrofit2.Response

class RgstrRepository {

    suspend fun pushPost(post : RegisterPost): Response<Int> {
        return RegisterRetrofitInstance.api.pushPost(post)
    }
}