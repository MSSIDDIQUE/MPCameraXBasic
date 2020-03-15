package com.android.example.cameraxbasic.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.example.cameraxbasic.data.Pics
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreSource() {

    private val firestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    private val ImageList = mutableListOf<Pics>()
    private val pics = MutableLiveData<List<Pics>>()

    init {
        pics.value = ImageList
    }


    fun getPics(): LiveData<List<Pics>>
    {
        firestore.collection("url").get().addOnCompleteListener { task ->
            if (task.isSuccessful)
            {
                ImageList.clear()
                for (pic in task.result!!)
                {
                    ImageList.add(Pics(pic.get("imageUrl").toString(),pic.get("name").toString()))
                }
                Log.d("EVENT","Live Data is updated")
            }
        }.addOnCompleteListener {
            pics.value = ImageList
        }
        return pics
    }
}