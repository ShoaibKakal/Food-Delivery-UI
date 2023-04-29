package com.example.fooddeliveryui.ui.util

import com.example.fooddeliveryui.R


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("Home", R.drawable.ic_home ,"home_screen")
    object Buy: BottomNavItem("Buy",R.drawable.ic_buy,"buy_screen")
    object Profile: BottomNavItem("Profile",R.drawable.ic_profile,"profile_screen")
    object Chat: BottomNavItem("Chat",R.drawable.ic_chat,"chat_screen")
}

object Destinations{
    const val DETAIL_PRODUCT_SCREEN = "detail_product_screen"
}
