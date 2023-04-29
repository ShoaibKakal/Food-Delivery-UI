package com.example.fooddeliveryui.ui.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fooddeliveryui.R

data class RestaurantModel(
    @DrawableRes val img:Int,
     val name:String,
    val timeAway:Int
)

val restaurants = mutableListOf(
    RestaurantModel(R.drawable.img_restaurant_1, "Vegan Restro", 10),
    RestaurantModel(R.drawable.img_restaurant_2, "Queens Food", 12),
    RestaurantModel(R.drawable.img_restaurant_3, "Smarti Restro", 14),
    RestaurantModel(R.drawable.img_restaurant_4, "Good Food", 16),
    RestaurantModel(R.drawable.img_restaurant_5, "Healthy Restro", 18),
    RestaurantModel(R.drawable.img_restaurant_6, "Hello Restro", 8),
)
