package com.example.fooddeliveryui.ui.screens

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryui.R
import com.example.fooddeliveryui.ui.data.MenuModel
import com.example.fooddeliveryui.ui.data.menus
import com.example.fooddeliveryui.ui.theme.DarkBlue100
import com.example.fooddeliveryui.ui.theme.FadeWhite
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.theme.PaleOrange100
import com.example.fooddeliveryui.ui.util.TextStyles
import kotlinx.coroutines.flow.distinctUntilChanged

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CartScreen() {
    val menuList = remember {
        mutableStateListOf<MenuModel>()
    }
    menuList.addAll(menus)
    val scrollState = rememberLazyListState()
    val isAtTop by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset == 0
        }
    }
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    val transparentGradientBrush = Brush.linearGradient(
        colors = listOf(
            Color(0x66FFFFFF),
            Color(0x1AFFFFFF)
        )
    )
    Surface {

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 60.dp)
        ) {


            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Order details",
                style = TextStyle(
                    fontSize = animateIntAsState(
                        targetValue = if (isAtTop) 30 else 20,
                        animationSpec = tween(durationMillis = 600)
                    ).value.sp,
                    color = DarkBlue100,
                    lineHeight = 40.sp,
                    fontFamily = FontFamily.SansSerif
                )
            )

//                Spacer(modifier = Modifier.height(12.dp))
            Box(
                Modifier.padding(top = 12.dp).weight(1f)
            ) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), state = scrollState) {


                    items(
                        items = menuList, key = { menus: MenuModel -> menus.id },
                        itemContent = {
                            val dismissState = rememberDismissState()
                            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                                menuList.remove(it)
                            }
                            SwipeToDismiss(
                                directions = setOf(DismissDirection.EndToStart),
                                state = dismissState,
                                background = {
                                    val color by animateColorAsState(
                                        when (dismissState.targetValue) {
                                            DismissValue.Default -> Color.White
                                            else -> PaleOrange100
                                        }
                                    )
                                    val alignment = Alignment.CenterEnd
                                    val icon = Icons.Outlined.Delete

                                    val scale by animateFloatAsState(
                                        if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                                    )

                                    Box(
                                        modifier = Modifier
//                                            .padding(top = 20.dp)
                                            .defaultMinSize(minHeight = 103.dp)
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(22.dp))
                                            .background(color),
                                        contentAlignment = alignment,
                                    ) {
                                        Icon(
                                            icon,
                                            contentDescription = "Delete Icon",
                                            modifier = Modifier.scale(scale).padding(end = 12.dp),
                                            tint = Color.White
                                        )
                                    }
                                }) {
                                ItemOrderCard(it)

                            }
                        },
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 206.dp)
                    .padding( bottom = 10.dp),
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
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 30.dp, vertical = 12.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        OrderDetailPricing("Sub-Total", "120 $")
                        OrderDetailPricing("Delivery Charges", "10 $")
                        OrderDetailPricing("Discount ", "20 $")
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Total", style = TextStyles.txtSansSerifBold18White())
                            Text(text = "150 $", style = TextStyles.txtSansSerifBold18White())
                        }
                        Spacer(modifier = Modifier.height(22.dp))
                        ElevatedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .defaultMinSize(minHeight = 57.dp),
                            onClick = { }, shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(
                                text = "Place My Order",
                                style = TextStyles.txtSansSerifSemiBold14Green()
                            )
                        }
                    }

                }
            }
        }
    }

}

@Composable
fun OrderDetailPricing(heading: String, price: String) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = heading, style = TextStyles.txtSansSerifRegular14White())
        Text(text = price, style = TextStyles.txtSansSerifRegular14White())
    }
}

@Composable
fun ItemOrderCard(menuModel: MenuModel) {
    Card(
        modifier = Modifier
            .defaultMinSize(minHeight = 103.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .clickable { },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = menuModel.img), contentDescription = "",
                modifier = Modifier.size(62.dp)
            )

            Column(
                Modifier
                    .padding(18.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start,

                ) {
                Text(text = menuModel.name, style = TextStyles.txtSansSerifSemiBold15DarkBlue())
                Text(
                    text = menuModel.restaurantName,
                    style = TextStyles.txtSansSerifRegular14SecondaryGreyAlhpa30()
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "$ ${menuModel.price}",
                    style = TextStyles.txtSansSerifSemiBold18Green()
                )
            }

            var quantity by remember {
                mutableStateOf(1)
            }
            Box(
                Modifier
                    .size(26.dp)
                    .clip(RoundedCornerShape(8))
                    .background(Green.copy(alpha = 0.1f))
                    .clickable {
                        quantity--
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "icon",
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = quantity.toString(), style = TextStyles.txtSansSerifRegular15DarkBlue())
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                Modifier
                    .size(26.dp)
                    .clip(RoundedCornerShape(8))
                    .background(Green)
                    .clickable { quantity++ },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "icon",
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartScreenPreview() {
    CartScreen()
}