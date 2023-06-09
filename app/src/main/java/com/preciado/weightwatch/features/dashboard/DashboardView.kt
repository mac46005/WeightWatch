package com.preciado.weightwatch.features.dashboard

import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.preciado.weightwatch.core.components.Graph
import com.preciado.weightwatch.core.components.LineGraph
import com.preciado.weightwatch.core.components.LineGraphv2
import kotlin.random.Random

@Composable
fun DashBoardView(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController
){
    Column (modifier = modifier){
        val yStep = 50
        val random = Random
        val points = (0..9).map{
            var num = random.nextInt(350)
            if(num <= 50){
                num += 100
            }
            num.toFloat()
        }
        //This will show a graph of all(or maybe from date to date) weight inputs
        Box(modifier = Modifier
            .weight(2f)
            .fillMaxWidth()){



//            LineGraph(
//                modifier = Modifier.fillMaxWidth().height(500.dp),
//                xValues = (0..9).map{it + 1},
//                yValues = (0..9).map{(it + 1) * yStep},
//                points = points,
//                paddingSpace = 16.dp,
//                verticalStep = yStep
//            )

            var xArea = mutableListOf<Float>()
            var yArea = mutableListOf<Float>()
            var points = mutableListOf<PointF>()

            for(i in 0 until 9){
                xArea.add(i.toFloat())
                yArea.add(i.toFloat())
                for (j in 0 until 9){
                    points.add(PointF(i.toFloat(),(j + 1).toFloat()))
                }
            }



            LineGraphv2(
                modifier = Modifier.fillMaxWidth().height(500.dp),
                xValues = xArea,
                yValues = yArea,
                points = points,
                paddingSpace = 10.dp,
                verticalStep = 50f
            )




        }
        //Shows relevant info such as weight average and eating habits
        Card(modifier = Modifier
            .weight(2f)
            .fillMaxWidth()
            .padding(10.dp)) {
            Column() {
                Text(text = "Relevant Information yo")
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Card() {
                        Text(text = "Card 1")
                    }
                    Card() {
                        Text(text = "Card 2")
                    }
                }
            }

        }





        //Buttons to navigate to other views
        BottomAppBar(modifier = Modifier) {

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Log Weight")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Log Food intake")
            }
        }
    }
}




@Preview
@Composable
fun DashboardViewPreview(){
    DashBoardView(navController = rememberNavController())
}