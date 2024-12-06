package com.example.customcompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customcompose.utils.ConverterUtils

@Composable
fun CustomToolbar(
    leftImage: Painter,
    rightImage: Painter,
    title: String,
    colorType: String? = null
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(76.dp)
        .padding(WindowInsets.statusBars.asPaddingValues())
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = if (colorType.isNullOrEmpty()) {
                    Color(0xFF0000FF)
                }else{
                    ConverterUtils.parseStringToColor(colorType)
                },
                size = this.size
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 10.dp, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = leftImage,
                contentDescription = "Left Icon",
                modifier = Modifier
                    .size(76.dp)
                    .padding(end = 10.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = title,
                style = TextStyle(fontSize = 18.sp, color = Color.White),
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = rightImage,
                contentDescription = "Right Icon",
                modifier = Modifier
                    .size(36.dp)
                    .padding(start = 10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}