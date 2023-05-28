package com.example.fooddeliveryui.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryui.R
import com.example.fooddeliveryui.ui.data.MenuModel
import com.example.fooddeliveryui.ui.data.RestaurantModel
import com.example.fooddeliveryui.ui.data.menus
import com.example.fooddeliveryui.ui.data.restaurants
import com.example.fooddeliveryui.ui.theme.FoodDeliveryUITheme
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.theme.PaleOrange40
import com.example.fooddeliveryui.ui.util.TextStyles


@Composable
fun DetailProductBottomSheet() {
    Column(
        modifier = Modifier
            .heightIn(max = 730.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(8.dp)
                .width(58.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(PaleOrange40)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Popular", style = TextStyles.txtSansSerifRegular12Green(),
                modifier = Modifier
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        Green.copy(alpha = 0.1f)
                    )
                    .padding(vertical = 7.dp, horizontal = 12.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
            RoundBackgroundIcon(R.drawable.ic_fill_location, Green.copy(alpha = 0.1f))
            Spacer(modifier = Modifier.width(10.dp))
            RoundBackgroundIcon(R.drawable.ic_heart, Color.Red.copy(alpha = 0.1f))
        }

        Text(
            text = "Wijie Bar and Resto",
            style = TextStyles.txtSansSerifBold27DarkBlue100(),
            modifier = Modifier.padding(top = 20.dp)
        )

        Row(
            Modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextWithIcon(R.drawable.ic_empty_location, "19 Km")
            Spacer(modifier = Modifier.width(20.dp))
            TextWithIcon(R.drawable.ic_rating_star, "4.8 Rating")
        }

        var showMoreText by remember {
            mutableStateOf(false)
        }
        val descMaxLines: Int by animateIntAsState(targetValue = if (showMoreText) 100000 else 5) // Int.MAX_VALUE


        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            item {
                Column {

                    Text(
                        modifier = Modifier.padding(top = 20.dp),
                        text = stringResource(id = R.string.restaurant_desc),
                        style = TextStyles.txtSansSerifRegular12DarkBlue(),
                        maxLines = descMaxLines
                    )
                    TextButton(
                        onClick = { showMoreText = !showMoreText },
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = if (showMoreText) "Show Less" else "Show More",
                            style = TextStyles.txtSansSerifRegular12Green(),
                        )
                    }

                    HeadingText(primaryHeading = "Popular Menu", secondaryHeading = "View All") {

                    }

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        //showing only last 2 items for popular
                        items(items = menus.subList(menus.size-3, menus.size)) {
                            ItemMenuGrid(menuModel = it)
                        }
                    }

                    Text(
                        modifier = Modifier.padding(top = 20.dp),
                        text = "Testimonials",
                        style = TextStyles.txtSansSerifBold15DarkBlue()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                }
            }
            items(3){
                ItemTestimonial()
            }
        }
    }
}

@Composable
fun ItemTestimonial() {
    Card(
        Modifier
            .padding(bottom = 20.dp)
            .height(128.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_profile_3),
                contentDescription = "image",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Row {
                    Column {
                        Text(
                            text = "Shoaib Kakal",
                            style = TextStyles.txtSansSerifSemiBold15DarkBlue()
                        )
                        Text(
                            text = "12 April 2023",
                            style = TextStyles.txtSansSerifRegular14SecondaryGreyAlhpa30()
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        Modifier
                            .padding(end = 20.dp)
                            .height(33.dp)
                            .width(55.dp)
                            .clip(RoundedCornerShape(18.dp))
                            .background(
                                Green.copy(alpha = 0.1f)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_fill_star),
                                contentDescription = "image",
                                modifier = Modifier
                                    .padding(end = 5.dp)
                                    .size(20.dp)
                            )
                            Text(text = "5", style = TextStyles.txtSansSerifSemiBold18Green())
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.testimonial_1), style = TextStyles.txtSansSerifRegular12DarkBlueAlpha50())
            }
        }

    }
}

@Composable
fun TextWithIcon(@DrawableRes icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon), contentDescription = "image", modifier = Modifier
                .padding(end = 10.dp)
                .size(20.dp)
        )
        Text(text = text, style = TextStyles.txtSansSerifRegular14SecondaryGreyAlhpa30())
    }
}
@Composable
fun ItemMenuGrid(menuModel: MenuModel) {
    Card(
        modifier = Modifier
            .height(184.dp)
            .width(147.dp),
//            .padding(end = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(78.dp)
                    .width(96.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = menuModel.img),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = menuModel.name, style = TextStyles.txtSansSerifRegular15DarkBlue())
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$ ${menuModel.price}",
                style = TextStyles.txtSansSerifRegular12DarkBlueAlpha50()
            )

        }
    }
}


@Preview
@Composable
fun DetailProductBottomSheetPrev() {
    FoodDeliveryUITheme {
        DetailProductBottomSheet()
    }
}