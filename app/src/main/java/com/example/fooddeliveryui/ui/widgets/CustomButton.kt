package com.example.fooddeliveryui.ui.widgets

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.util.TextStyles

enum class ButtonShape {
    SQUARE,
    ROUNDED_BORDER_6,
    ROUNDED_BORDER_8,
    ROUNDED_BORDER_24,
    ROUNDED_BORDER_20,
}

enum class ButtonPadding {
    PADDING_ALL_16,
    PADDING_TOP_17,
    PADDING_ALL_17,
    PADDING_H16_V8
}

enum class ButtonVariant {
    FILL_GREEN,
    FILL_WHITE,
    FILL_BLACK,
    OUTLINE_RED
}

enum class ButtonStyle {
    INTER_REGULAR_12,
    INTER_REGULAR_12_GREEN,
    INTER_BOLD_12_GREEN,
    SANS_SERIF_BOLD_10_GREEN,
    SANS_SERIF_12_GREEN,
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    shape: ButtonShape? = null,
    padding: ButtonPadding? = null,
    variant: ButtonVariant? = null,
    style: ButtonStyle? = null,
    onTap: () -> Unit
) {

    Box(
        modifier = modifier
            .clip(getButtonShape(shape))
            .clickable { onTap() }
            .getVariant(variant)
            .getPadding(padding)
            ,
    ) {
        Text(text = text, style = getTextStyle(style))
    }
}

private fun getTextStyle(style: ButtonStyle?): TextStyle {
    return when(style)
    {
        ButtonStyle.INTER_REGULAR_12 ->{
            TextStyle(
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
            )
        }

        ButtonStyle.INTER_REGULAR_12_GREEN ->{
            TextStyle(
                color = Green   ,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
            )
        }

        ButtonStyle.SANS_SERIF_BOLD_10_GREEN ->{
            TextStyle(
                color = Green   ,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
            )
        }
        ButtonStyle.SANS_SERIF_12_GREEN ->{
            TextStyles.txtSansSerifRegular12Green()
        }


        ButtonStyle.INTER_BOLD_12_GREEN ->{
            TextStyle(
                color = Color.Green,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        else ->{
            TextStyle(
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
            )
        }
    }
}


private fun Modifier.getVariant(variant: ButtonVariant?): Modifier {
    return when (variant) {
        ButtonVariant.FILL_BLACK->{
            this.background(Color.Black)
        }
        ButtonVariant.FILL_GREEN ->{
            this.background(Color.Green)
        }
        ButtonVariant.OUTLINE_RED ->{
            this.border(width = 1.dp, color = Color.Red)
        }
        ButtonVariant.FILL_WHITE ->{
            this.background(Color.White)
        }
        else -> {
            this.border(width = 1.dp, color = Color.Black)
        }
    }
}

private fun getButtonShape(shape: ButtonShape?): Shape {
    return when (shape) {
        ButtonShape.SQUARE -> {
            RoundedCornerShape(0)
        }

        ButtonShape.ROUNDED_BORDER_8 -> {
            RoundedCornerShape(8)
        }

        ButtonShape.ROUNDED_BORDER_20 -> {
            RoundedCornerShape(20)
        }

        ButtonShape.ROUNDED_BORDER_24 -> {
            RoundedCornerShape(24)
        }

        ButtonShape.ROUNDED_BORDER_6 ->{
            RoundedCornerShape(6)
        }

        else -> {
            RoundedCornerShape(0)
        }
    }
}

private fun Modifier.getPadding(value: ButtonPadding?): Modifier {
    return when (value) {
        ButtonPadding.PADDING_ALL_16 ->
            this.padding(all = 16.dp)

        ButtonPadding.PADDING_ALL_17 ->
            this.padding(all = 17.dp)

        ButtonPadding.PADDING_TOP_17 ->
            this.padding(top = 17.dp)

        ButtonPadding.PADDING_H16_V8 ->
            this.padding(horizontal = 16.dp, vertical = 8.dp)

        else -> {
            this.padding(all= 8.dp)
        }
    }
}


