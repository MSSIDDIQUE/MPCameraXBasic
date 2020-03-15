package com.android.example.cameraxbasic.viewmodels

import androidx.lifecycle.ViewModel
import com.android.example.cameraxbasic.data.Repository

class PicsViewModel(private val repository: Repository):ViewModel() {
    fun getPics() = repository.getPics()
}