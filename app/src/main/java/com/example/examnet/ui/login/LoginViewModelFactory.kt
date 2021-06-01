package com.example.examnet.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.login.loginRepository.LgnRepository

class LoginViewModelFactory (
    private val repository: LgnRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return LoginViewModel(repository) as T
    }
}