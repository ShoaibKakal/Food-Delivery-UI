package com.example.fooddeliveryui.ui.data

import androidx.annotation.DrawableRes
import com.example.fooddeliveryui.R

data class ChatModelItem(
    @DrawableRes val img: Int,
    val name: String)


val chatModelItems = mutableListOf(
    ChatModelItem(R.drawable.img_profile, "Ayesha"),
    ChatModelItem(R.drawable.img_profile_2, "Arslan"),
    ChatModelItem(R.drawable.img_profile_3, "Shoaib"),
)