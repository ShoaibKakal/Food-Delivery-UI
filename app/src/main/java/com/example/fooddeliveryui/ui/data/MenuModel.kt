package com.example.fooddeliveryui.ui.data
import androidx.annotation.DrawableRes
import com.example.fooddeliveryui.R

data class MenuModel(
    val id:Int,
    @DrawableRes val img: Int,
    val name: String,
    val restaurantName: String,
    val price: Int
)

val menus = mutableListOf(
    MenuModel(
        1,
        img = R.drawable.img_menu_1,
        "Herbal Pancake",
        "Warung Herbal",
        10
    ),
    MenuModel(
        2,
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),
    MenuModel(
        3,
        img = R.drawable.img_menu_3,
        "Green Noddle",
        "Noodle Home",
        19
    ),


    MenuModel(
        4,
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),
    MenuModel(
        5,
        img = R.drawable.img_menu_3,
        "Green Noddle",
        "Noodle Home",
        19
    ),

    MenuModel(
        6,
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),    MenuModel(
        7,
        img = R.drawable.img_menu_1,
        "Herbal Pancake",
        "Warung Herbal",
        10
    ),
    MenuModel(
        8,
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),
    MenuModel(
        9,
        img = R.drawable.img_menu_3,
        "Green Noddle",
        "Noodle Home",
        19
    ),

    MenuModel(
        10,
        img = R.drawable.img_menu_2,
        "Fruit Salad",
        "Wijie Resto",
        13
    ),

    MenuModel(
        11,
        img = R.drawable.img_menu_4,
        "Spicy Fresh crab",
        "Wijie Resto",
        13
    ),
    MenuModel(
        12,
        img = R.drawable.img_menu_5,
        "Herbal Pancake",
        "Warung Herbal",
        10
    ),

    MenuModel(
        13,
        img = R.drawable.img_menu_4,
        "Spicy Fresh crab",
        "Wijie Resto",
        13
    ),
)