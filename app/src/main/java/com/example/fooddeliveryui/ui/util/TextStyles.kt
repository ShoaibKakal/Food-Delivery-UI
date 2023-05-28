package com.example.fooddeliveryui.ui.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryui.ui.theme.DarkBlue100
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.theme.PaleRed100
import com.example.fooddeliveryui.ui.theme.PaleRed80
import com.example.fooddeliveryui.ui.theme.SecondaryGrey

object TextStyles {

    fun txtSanSerifRegular31DarkBlue100(): TextStyle {
        return TextStyle(
            fontSize = 32.sp,
            color = DarkBlue100,
            lineHeight = 40.sp,
            fontFamily = FontFamily.SansSerif
        )
    }

    fun txtSanSerifRegular12PaleRed40(): TextStyle {
        return TextStyle(
            fontSize = 12.sp,
            color = PaleRed100.copy(alpha = 0.4f),
            fontFamily = FontFamily.SansSerif,

            )
    }

    fun txtSanSerifRegular12PaleRed80(): TextStyle {
        return TextStyle(
            fontSize = 12.sp,
            color = PaleRed80,
            fontFamily = FontFamily.SansSerif,

            )
    }

    fun txtSansSerifRegular17White(): TextStyle {
        return TextStyle(
            fontSize = 17.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,

            )
    }

    fun txtSansSerifRegular12Green(): TextStyle {
        return TextStyle(
            fontSize = 12.sp,
            color = Green,
            fontFamily = FontFamily.SansSerif,
        )
    }

    fun txtSansSerifRegular12DarkBlue(): TextStyle {
        return TextStyle(
            fontSize = 12.sp,
            color = DarkBlue100,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 15.sp
        )
    }

    fun txtSansSerifBold15DarkBlue(): TextStyle {
        return TextStyle(
            fontSize = 15.sp,
            color = DarkBlue100,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W900
        )
    }
    fun txtSansSerifSemiBold15DarkBlue(): TextStyle {
        return TextStyle(
            fontSize = 15.sp,
            color = DarkBlue100,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600
        )
    }

    fun txtSansSerifRegular15DarkBlue(): TextStyle {
        return TextStyle(
            fontSize = 15.sp,
            color = DarkBlue100,
            fontFamily = FontFamily.SansSerif,
        )
    }
    fun txtSansSerifRegular12DarkBlueAlpha50(): TextStyle {
        return TextStyle(
            fontSize = 12.sp,
            color = DarkBlue100.copy(alpha = 0.5f),
            fontFamily = FontFamily.SansSerif,
        )
    }

    fun txtSansSerifRegular22PaleRed80Alpha60(): TextStyle {
        return TextStyle(
            fontSize = 22.sp,
            color = PaleRed80.copy(alpha = 0.6f),
            fontFamily = FontFamily.SansSerif,
        )
    }

    fun txtSansSerifRegular14SecondaryGreyAlhpa30(): TextStyle {
        return TextStyle(
            fontSize = 14.sp,
            letterSpacing = 0.5.sp,
            color = SecondaryGrey.copy(alpha = 0.3f),
            fontFamily = FontFamily.SansSerif,
        )
    }

    fun txtSansSerifSemiBold18Green(): TextStyle {
        return TextStyle(
            fontSize = 18.sp,
            color = Green,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600
        )
    }

    fun txtSansSerifRegular14White(): TextStyle {
        return TextStyle(
            fontSize = 14.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
        )
    }

    fun txtSansSerifBold18White(): TextStyle {
        return TextStyle(
            fontSize = 18.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    }

    fun txtSansSerifRegular12PaleRed100(): TextStyle {
        return TextStyle(
            fontSize = 12.sp,
            color = PaleRed100,
            fontFamily = FontFamily.SansSerif,
        )
    }

    fun txtSansSerifSemiBold14PaleRed100(): TextStyle {
        return TextStyle(
            fontSize = 14.sp,
            color = PaleRed100,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W600
        )
    }

    fun txtSansSerifSemiBold14Green(): TextStyle {
        return TextStyle(
            fontSize = 14.sp,
            color = Green,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    }


    fun txtSansSerifBold27DarkBlue100(): TextStyle {
        return TextStyle(
            fontSize = 27.sp,
            color = DarkBlue100,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W700
        )
    }


}