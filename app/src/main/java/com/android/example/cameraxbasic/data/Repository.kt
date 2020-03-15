package com.android.example.cameraxbasic.data

import androidx.lifecycle.LiveData
import com.android.example.cameraxbasic.data.network.FirestoreSource

class Repository(private val firestoreSource: FirestoreSource) {

    fun getPics() = firestoreSource.getPics()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: Repository? = null

        fun getInstance(firestoreSource: FirestoreSource) =
                instance ?: synchronized(this) {
                    instance ?: Repository(firestoreSource).also { instance = it }
                }
    }
}