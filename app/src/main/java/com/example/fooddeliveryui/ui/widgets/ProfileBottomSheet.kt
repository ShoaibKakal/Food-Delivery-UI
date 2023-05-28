package com.example.fooddeliveryui.ui.screens

import android.widget.TextView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryui.R
import com.example.fooddeliveryui.ui.data.MenuModel
import com.example.fooddeliveryui.ui.data.menus
import com.example.fooddeliveryui.ui.theme.FoodDeliveryUITheme
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.theme.PaleOrange40
import com.example.fooddeliveryui.ui.theme.PaleOrange60
import com.example.fooddeliveryui.ui.util.TextStyles

@Composable
fun ProfileBottomSheet() {
    Column(
        modifier = Modifier.heightIn(max = 730.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(8.dp)
                .width(58.dp).clip(RoundedCornerShape(8.dp))
                .background(PaleOrange40)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Member Gold", modifier = Modifier
                .clip(
                    RoundedCornerShape(18.dp)
                )
                .background(PaleOrange40)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            style = TextStyles.txtSansSerifSemiBold14PaleRed100()
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Shoaib Kakal", style = TextStyles.txtSansSerifBold27DarkBlue100())
                Text(
                    text = "Shoaib@gmx.us",
                    style = TextStyles.txtSansSerifRegular14SecondaryGreyAlhpa30()
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.ic_edit_pen),
                    contentDescription = "image"
                )
            }
        }

        Card(
            Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(22.dp)).clickable {  },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Row(
                Modifier.fillMaxSize().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_voucher),
                    contentDescription = "image",
                    modifier = Modifier.size(45.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "You Have 3 Vouchers",
                    style = TextStyles.txtSansSerifSemiBold15DarkBlue()
                )
            }

        }

        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Favorite",
            style = TextStyles.txtSansSerifBold15DarkBlue()
        )

        LazyColumn {
            items(items = menus.subList(0, menus.size)) {
                ItemFavoriteCard(menuModel = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemFavoriteCard(menuModel: MenuModel) {
    Card(
        modifier = Modifier
            .padding(top = 20.dp)
            .height(103.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp)).clickable {  },
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

//            CompositionLocalProvider(
//                LocalMinimumTouchTargetEnforcement provides false,
//            ){
//                Button(
//                    modifier = Modifier
//                        .defaultMinSize(minWidth = 85.dp, minHeight = 29.dp)
//                        .background(
//                            brush = Brush.horizontalGradient(
//                                colors = listOf(
//                                    Green.copy(alpha = 0.65f),
//                                    Green,
//                                )
//                            ), shape = RoundedCornerShape(15.dp)
//                        )
//                    ,contentPadding = PaddingValues(0.dp),
//                    onClick = {
//                    },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
//                ) {
//                    Text(text = "Buy Again", style = TextStyles.txtSansSerifRegular14White())
//
//                }
//            }
            Text(
                text = "Buy Again", style = TextStyles.txtSansSerifRegular14White(),
                modifier = Modifier
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Green.copy(alpha = 0.65f),
                                Green,
                            )
                        )
                    ).clickable {  }
                    .padding(vertical = 7.dp, horizontal = 12.dp)
            )


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileBottomSheetPrev() {
    FoodDeliveryUITheme {
        ProfileBottomSheet()
    }
}