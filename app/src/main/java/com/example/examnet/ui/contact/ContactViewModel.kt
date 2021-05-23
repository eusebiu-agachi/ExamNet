package com.example.examnet.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.contact.contactModel.ContactPost
import com.example.examnet.ui.contact.contactRepository.ContactRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ContactViewModel(private val repository : ContactRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Sebi este prost"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<Int>> = MutableLiveData()

    fun pushPost(post : ContactPost) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}