package com.example.mygaminggear

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gear(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable
