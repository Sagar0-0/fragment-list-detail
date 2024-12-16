package com.speechify.android.ui.test.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val id: Int,
    val title: String,
    val author: String
) : Parcelable