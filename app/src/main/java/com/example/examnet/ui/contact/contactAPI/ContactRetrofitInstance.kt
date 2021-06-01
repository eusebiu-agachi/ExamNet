package com.example.examnet.ui.contact.contactAPI

import com.example.examnet.ui.contact.contactUtil.ContactConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ContactRetrofitInstance {
    companion object {
        const val BASE_URL = "http://89.137.141.228:8080/contact"
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(ContactConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: ContactSimpleApi by lazy {
            retrofit.create(ContactSimpleApi::class.java)
        }
    }
}