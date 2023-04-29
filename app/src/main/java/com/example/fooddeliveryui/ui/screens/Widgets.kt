package com.example.fooddeliveryui.ui.screens

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryui.R
import com.example.fooddeliveryui.ui.theme.PaleOrange40
import com.example.fooddeliveryui.ui.theme.PaleOrange60
import com.example.fooddeliveryui.ui.theme.PaleOrange80
import com.example.fooddeliveryui.ui.util.TextStyles

@Composable
fun SecondaryIconButton(
    @DrawableRes icon: Int,
    width: Int = 50,
    height: Int = 55,
    onIconClicked: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(PaleOrange40)
                .clickable { onIconClicked() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "icon"
            )
        }
    }
}

@Composable
fun ItemFilter(filter: String, onFilterClicked: () -> Unit) {
    var isSelected by remember { mutableStateOf(false) }
    Text(
        text = filter, modifier = Modifier
            .clip(
                RoundedCornerShape(12.dp)
            )
            .background(if (isSelected) PaleOrange60 else PaleOrange40)
            .clickable {
                onFilterClicked()
                isSelected = !isSelected
            }
            .padding(vertical = 16.dp, horizontal = 20.dp),
        style = TextStyles.txtSansSerifRegular12PaleRed100()
    )
}

@Composable
fun RoundBackgroundIcon(@DrawableRes icon: Int, bgColor: Color) {
    Box(
        Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "icon",
            modifier = Modifier.size(16.dp)
        )
    }
}