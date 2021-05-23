package com.example.examnet.ui.contact.contactAPI

import com.example.examnet.ui.contact.contactModel.ContactPost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ContactSimpleApi {
    @POST("http://89.137.141.228:8080/contact/insert")
    suspend fun pushPost(@Body post : ContactPost): Response<Int>
}