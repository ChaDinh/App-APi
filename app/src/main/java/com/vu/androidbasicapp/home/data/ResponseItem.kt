package com.vu.androidbasicapp.home.data

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseItem(
    val technique: String,
    val equipment: String,
    val subject: String,
    val pioneeringPhotographer: String,
    val yearIntroduced: Int,
    val description: String
): Parcelable