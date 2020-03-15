package com.android.example.cameraxbasic.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.cameraxbasic.data.Repository

class PicsViewModelFactory(private val repository:Repository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PicsViewModel(repository) as T
    }
}