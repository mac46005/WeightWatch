package com.preciado.weightwatch.core.components

import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun LineGraphv2(
    modifier: Modifier,
    xValues: List<Float>,
    yValues: List<Float>,
    points: List<PointF>,
    paddingSpace: Dp,
    verticalStep: Float
){
    val coordinates = mutableListOf<PointF>()
    val density = LocalDensity.current
    val textPaint = remember(density){
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Box(
        modifier = modifier
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.fillMaxWidth()){
            val xAxisSpace = (size.width - paddingSpace.toPx()) / xValues.size
            val yAxisSpace = size.height / yValues.size

            //placing x axis points
            for(i in xValues.indices){
                drawContext.canvas.nativeCanvas.drawText(
                    "${xValues[i]}",
                    xAxisSpace * (i + 1),
                    size.height - (yAxisSpace * (points[i].y/verticalStep.toFloat())),
                    textPaint
                )
            }

            // placing y axis values
            for(i in yValues.indices){
                drawContext.canvas.nativeCanvas.drawText(
                    "${yValues[i]}",
                    paddingSpace.toPx() / 2f,
                    size.height - yAxisSpace * (i + 1),
                    textPaint
                )
            }

            // placing points
            for(i in points.indices){
                drawCircle(
                    color = Color.Red,
                    radius = 10f,
                    center = Offset(points[i].x,points[i].y)
                )
            }
        }
    }
}


@Preview
@Composable
fun LineGraphv2Preview(){
    var xValues = mutableListOf<Float>()
    var yValues = mutableListOf<Float>()
    var points = mutableListOf<PointF>()
    var random = Random
    for(i in 0..9){
        xValues.add(i.toFloat())
        yValues.add(i.toFloat())
        points.add(PointF(i.toFloat(), (i + random.nextInt() * 100).toFloat()))
    }

    LineGraphv2(
        modifier = Modifier.fillMaxWidth().height(500.dp),
        xValues = xValues,
        yValues = yValues,
        points = points,
        paddingSpace = 16.dp,
        verticalStep = 40f
    )
}