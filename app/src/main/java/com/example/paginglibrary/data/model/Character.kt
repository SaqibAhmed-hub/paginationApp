package com.example.paginglibrary.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    val location: location
): Parcelable

@Parcelize
data class location(
    val name: String,
    val url: String
): Parcelable
