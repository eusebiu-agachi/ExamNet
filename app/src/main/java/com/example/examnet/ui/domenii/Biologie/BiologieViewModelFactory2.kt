package com.example.examnet.ui.domenii.Biologie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.domenii.Biologie.biologieRepository.BiologieRepository

class BiologieViewModelFactory2 (
    private val repository: BiologieRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BiologieViewModel(repository) as T
    }
}