package com.example.fooddeliveryui

import Glassmorpshism
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fooddeliveryui.ui.BottomNav
import com.example.fooddeliveryui.ui.theme.FoodDeliveryUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryUITheme {
                BottomNav()
            }
        }
    }
}
