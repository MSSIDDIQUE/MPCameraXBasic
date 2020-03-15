package com.android.example.cameraxbasic.data

import android.os.Parcelable
import com.android.example.cameraxbasic.data.Pics
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pictures:ArrayList<Pics>(),Parcelable {
}