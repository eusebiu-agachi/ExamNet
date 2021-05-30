package com.example.examnet.ui.login.loginRepository

import com.example.examnet.ui.login.loginApi.loginRetrofitInstance
import com.example.examnet.ui.login.loginModel.loginPost
import com.example.examnet.ui.login.loginModel.loginResponse
import retrofit2.Response

class lgnRepository {

    suspend fun pushPost(post : loginPost): Response<loginResponse> {
        return loginRetrofitInstance.api.pushPost(post)
    }
}