package com.example.examnet.ui.userProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserProfileViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is userProfile fragment"
    }
    val text: LiveData<String> = _text

}