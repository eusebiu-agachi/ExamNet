package com.example.examnet.ui.login.loginRepository

import com.example.examnet.ui.login.loginApi.loginRetrofitInstance
import com.example.examnet.ui.login.loginModel.loginPost
import retrofit2.Response

class lgnRepository {

    suspend fun pushPost(post : loginPost): Response<Int> {
        return loginRetrofitInstance.api.pushPost(post)
    }
}