package com.example.fooddeliveryui.ui

import FilterBottomSheet
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fooddeliveryui.ui.screens.CartScreen
import com.example.fooddeliveryui.ui.screens.ChatScreen
import com.example.fooddeliveryui.ui.screens.DetailProductScreen
import com.example.fooddeliveryui.ui.screens.HomeScreen
import com.example.fooddeliveryui.ui.screens.ProfileScreen
import com.example.fooddeliveryui.ui.theme.DarkBlue100
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.util.BottomNavItem
import com.example.fooddeliveryui.ui.util.Destinations
import kotlinx.coroutines.launch


@Composable
fun NavigationGraph(navController: NavHostController, onClickForOpenFilterBottomSheet:()->Unit) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen(onClickForOpenFilterBottomSheet, onRestaurantItemClicked = {
                navController.navigate(Destinations.DETAIL_PRODUCT_SCREEN)
            })
        }
        composable(BottomNavItem.Buy.screen_route) {
            CartScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen()
        }
        composable(BottomNavItem.Chat.screen_route) {
            ChatScreen()
        }
        composable(Destinations.DETAIL_PRODUCT_SCREEN) {
            DetailProductScreen()
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNav() {
    val navController = rememberNavController()

    val filterSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
    )

    val coroutineScope = rememberCoroutineScope()

    BackHandler(filterSheetState.isVisible) {
        coroutineScope.launch { filterSheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = filterSheetState,
        sheetContent = { FilterBottomSheet {
            coroutineScope.launch {
                filterSheetState.hide()
            }
        }
        },
        modifier = Modifier.fillMaxSize(),
    ){
        Scaffold(
            bottomBar = {
                BottomBar(navController = navController )
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                NavigationGraph(navController = navController) {
                    coroutineScope.launch {
                        if (filterSheetState.isVisible) filterSheetState.hide()
                        else filterSheetState.show()
                    }
                }
            }
        }
    }

}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavItem.Home,
        BottomNavItem.Buy,
        BottomNavItem.Profile,
        BottomNavItem.Chat,
    )
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    
    when (navStackBackEntry?.destination?.route) {
        BottomNavItem.Home.screen_route -> {
            bottomBarState.value = true
        }
        BottomNavItem.Buy.screen_route-> {
            bottomBarState.value = true
        }
        BottomNavItem.Profile.screen_route -> {
            bottomBarState.value = true
        }
        BottomNavItem.Chat.screen_route -> {
            bottomBarState.value = true
        }
        else -> {
            bottomBarState.value = false
        }
    }

    AnimatedVisibility(visible = bottomBarState.value) {
        Row(
            modifier = Modifier
                .height(70.dp)
                .background(Color.White)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.screen_route } == true

    val background =
        if (selected) Green.copy(alpha = 0.1f) else Color.Transparent

    val contentColor = Green
//        if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.screen_route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.icon else screen.icon),
                contentDescription = "icon",
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = DarkBlue100,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun BottomNavPreview() {
    BottomNav()
}
