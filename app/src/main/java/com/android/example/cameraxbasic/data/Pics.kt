package com.android.example.cameraxbasic.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pics(val imageUrl:String,
                val name:String) :Parcelable
