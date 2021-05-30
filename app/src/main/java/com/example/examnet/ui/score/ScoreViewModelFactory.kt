package com.example.examnet.ui.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.score.scoreRepository.ScoreRepository

class ScoreViewModelFactory (
    private val repository: ScoreRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return ScoreViewModel(repository) as T
    }
}