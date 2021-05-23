package com.example.examnet.ui.contact.contactRepository

import com.example.examnet.ui.contact.contactAPI.ContactRetrofitInstance
import com.example.examnet.ui.contact.contactModel.ContactPost

import retrofit2.Response

class ContactRepository {

    suspend fun pushPost(post : ContactPost): Response<Int> {
        return ContactRetrofitInstance.api.pushPost(post)
    }
}