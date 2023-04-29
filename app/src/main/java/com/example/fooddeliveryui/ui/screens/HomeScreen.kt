package com.example.fooddeliveryui.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryui.R
import com.example.fooddeliveryui.ui.data.MenuModel
import com.example.fooddeliveryui.ui.data.RestaurantModel
import com.example.fooddeliveryui.ui.data.menus
import com.example.fooddeliveryui.ui.data.restaurants
import com.example.fooddeliveryui.ui.theme.FoodDeliveryUITheme
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.theme.PaleOrange100
import com.example.fooddeliveryui.ui.theme.PaleOrange40
import com.example.fooddeliveryui.ui.util.TextStyles
import com.example.fooddeliveryui.ui.widgets.ButtonPadding
import com.example.fooddeliveryui.ui.widgets.ButtonShape
import com.example.fooddeliveryui.ui.widgets.ButtonStyle
import com.example.fooddeliveryui.ui.widgets.ButtonVariant
import com.example.fooddeliveryui.ui.widgets.CustomButton
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClickForOpenFilterBottomSheet: () -> Unit,
    onRestaurantItemClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 16.dp, end = 16.dp, top = 60.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.find_your_favorite_food),
                style = TextStyles.txtSanSerifRegular31DarkBlue100()
            )
            Card(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),

                ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.surface),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        colorFilter = ColorFilter.tint(Green),
                        painter = painterResource(id = R.drawable.ic_notification_with_dot),
                        contentDescription = ""
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var inputText by remember { mutableStateOf("") }

            TextField(
                modifier = Modifier.weight(1f),
                value = inputText,
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "Icon",
                        modifier = Modifier.size(24.dp),
                    )
                },
                placeholder = {
                    Text(
                        text = "What do you want to order?",
                        style = TextStyles.txtSanSerifRegular12PaleRed40()
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    disabledLabelColor = PaleOrange100,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = PaleOrange40
                ),
                textStyle = TextStyles.txtSanSerifRegular12PaleRed40(),
                onValueChange = {
                    inputText = it
                },
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.width(8.dp))

            SecondaryIconButton(icon = R.drawable.ic_filter, onIconClicked = {
                onClickForOpenFilterBottomSheet()
            })
        }

        var viewMoreRestaurant by remember {
            mutableStateOf(true)
        }

        var viewMoreMenus by remember {
            mutableStateOf(true)
        }

        LazyColumn {
            item {
                AnimatedVisibility(visible = viewMoreRestaurant && viewMoreMenus) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(155.dp)
                            .padding(top = 20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Green
                        )
                    ) {
                        Box {
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                painter = painterResource(id = R.drawable.pattern),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Image(
                                modifier = Modifier.fillMaxHeight(),
                                painter = painterResource(id = R.drawable.img_icecream),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .align(Alignment.CenterEnd)
                                    .padding(end = 30.dp), verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Special Deal For\nOctober",
                                    style = TextStyles.txtSansSerifRegular17White()
                                )
                                Spacer(modifier = Modifier.padding(top = 4.dp))
                                ElevatedButton(
                                    onClick = { }, shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = "Buy now",
                                        style = TextStyles.txtSansSerifRegular12Green()
                                    )
                                }
                            }

                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                AnimatedVisibility(visible = viewMoreMenus) {
                    HeadingText(
                        "Nearest Restaurant", if (viewMoreRestaurant) "View More" else "View Less"
                    ) {
                        viewMoreRestaurant = !viewMoreRestaurant
                    }
                }
            }
            item {
                AnimatedVisibility(visible = viewMoreRestaurant && viewMoreMenus) {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), content = {
                        items(items = restaurants) {
                            ItemRestaurantCard(it, onRestaurantItemClicked)
                        }
                    })
                }
            }
            item {
                AnimatedVisibility(visible = viewMoreRestaurant) {
                    HeadingText("Popular Menu", if (viewMoreMenus) "View More" else "View Less") {
                        viewMoreMenus = !viewMoreMenus
                    }
                }
            }

            items(items = menus.subList(0, if (viewMoreMenus) 3 else menus.size)) {
                AnimatedVisibility(
                    visible = viewMoreRestaurant, modifier = Modifier.fillMaxHeight()
                ) {
                    ItemMenuCard(menuModel = it)
                }
            }
        }

        AnimatedVisibility(visible = !viewMoreRestaurant) {
            LazyVerticalGrid(columns = GridCells.Fixed(2),
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                content = {
                    items(items = restaurants) {
                        ItemRestaurantCard(it, onRestaurantItemClicked)
                    }
                })
        }
    }
}

@Composable
fun ItemMenuCard(menuModel: MenuModel) {
    Card(
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .padding(top = 12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .height(66.dp)
                    .width(66.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = menuModel.img),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(18.dp))
            Column {
                Text(text = menuModel.name, style = TextStyles.txtSansSerifRegular15DarkBlue())
                Text(
                    text = menuModel.restaurantName,
                    style = TextStyles.txtSansSerifRegular12DarkBlueAlpha50()
                )
            }

            Text(
                text = "$${menuModel.price}",
                style = TextStyles.txtSansSerifRegular22PaleRed80Alpha60(),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
fun HeadingText(primaryHeading: String, secondaryHeading: String, onHeadingClicked: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = primaryHeading, style = TextStyles.txtSansSerifBold15DarkBlue()
        )
        TextButton(
            onClick = onHeadingClicked,
            content = {
                Text(
                    text = secondaryHeading, style = TextStyles.txtSanSerifRegular12PaleRed80()
                )
            },
        )
    }
}

@Composable
fun ItemRestaurantCard(restaurantModel: RestaurantModel, onRestaurantItemClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .height(184.dp)
            .width(147.dp),
//            .padding(end = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .clickable {
                    onRestaurantItemClicked()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(78.dp)
                    .width(96.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = restaurantModel.img),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = restaurantModel.name, style = TextStyles.txtSansSerifRegular15DarkBlue())
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${restaurantModel.timeAway} Mins",
                style = TextStyles.txtSansSerifRegular12DarkBlueAlpha50()
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryUITheme {
        HomeScreen({}, {})
    }
}