package com.example.examnet.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.login.loginRepository.lgnRepository

class loginViewModelFactory (
    private val repository: lgnRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return LoginViewModel(repository) as T
    }
}