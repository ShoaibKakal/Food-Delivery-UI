package com.example.fooddeliveryui.ui.data
import androidx.annotation.DrawableRes
import com.example.fooddeliveryui.R

data class MenuModel(
    @DrawableRes val img: Int,
    val name: String,
    val restaurantName: String,
    val price: Int
)

val menus = mutableListOf(
    MenuModel(
        img = R.drawable.img_menu_1,
        "Herbal Pancake",
        "Warung Herbal",
        10
    ),
    MenuModel(
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),
    MenuModel(
        img = R.drawable.img_menu_3,
        "Green Noddle",
        "Noodle Home",
        19
    ),


    MenuModel(
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),
    MenuModel(
        img = R.drawable.img_menu_3,
        "Green Noddle",
        "Noodle Home",
        19
    ),

    MenuModel(
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),    MenuModel(
        img = R.drawable.img_menu_1,
        "Herbal Pancake",
        "Warung Herbal",
        10
    ),
    MenuModel(
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),
    MenuModel(
        img = R.drawable.img_menu_3,
        "Green Noddle",
        "Noodle Home",
        19
    ),

    MenuModel(
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),

    MenuModel(
        img = R.drawable.img_menu_4,
        "Spicy Fresh crab",
        "Wijie Resto",
        13
    ),
    MenuModel(
        img = R.drawable.img_menu_5,
        "Herbal Pancake",
        "Warung Herbal",
        10
    ),

    MenuModel(
        img = R.drawable.img_menu_4,
        "Spicy Fresh crab",
        "Wijie Resto",
        13
    ),
)