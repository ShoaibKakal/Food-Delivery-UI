package com.example.fooddeliveryui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryui.R
import com.example.fooddeliveryui.ui.data.ChatModelItem
import com.example.fooddeliveryui.ui.data.chatModelItems
import com.example.fooddeliveryui.ui.theme.FoodDeliveryUITheme
import com.example.fooddeliveryui.ui.util.TextStyles


@Composable
fun ChatScreen() {
    Surface {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 60.dp)
        ) {
//            SecondaryIconButton(R.drawable.ic_back, width = 50, height = 50)
            Text(
                text = stringResource(id = R.string.chat),
                style = TextStyles.txtSanSerifRegular31DarkBlue100()
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                items(items = chatModelItems, itemContent = {
                    ItemChatCard(it)
                }, )
            }
        }
    }
}

@Composable
fun ItemChatCard(chatModelItem: ChatModelItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .clip(RoundedCornerShape(22.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = chatModelItem.img),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(
                modifier = Modifier.padding(start = 18.dp)
            ) {
                Text(text = chatModelItem.name, style = TextStyles.txtSansSerifRegular15DarkBlue())
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Your Order Just Arrived!",
                    style = TextStyles.txtSansSerifRegular14SecondaryGreyAlhpa30()
                )
            }

            Text(
                text = "20:00", style = TextStyles.txtSansSerifRegular14SecondaryGreyAlhpa30(),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Top),
                textAlign = TextAlign.End,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    FoodDeliveryUITheme {
        ChatScreen()
    }
}