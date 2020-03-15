package com.android.example.cameraxbasic.data

data class Pics(val imageUrl:String,
                val name:String) {
    override fun toString(): String {
        return "$imageUrl - $name"
    }
}