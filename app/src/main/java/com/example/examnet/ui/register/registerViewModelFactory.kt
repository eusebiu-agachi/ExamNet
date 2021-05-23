package com.example.examnet.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.register.registerRepository.rgstrRepository

class registerViewModelFactory(
    private val repository: rgstrRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterViewModel(repository) as T
    }
}