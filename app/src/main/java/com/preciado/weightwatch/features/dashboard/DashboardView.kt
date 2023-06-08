package com.preciado.weightwatch.features.dashboard

import android.graphics.Paint
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun DashBoardView(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController
){
    Column (modifier = modifier){
        
        //This will show a graph of all(or maybe from date to date) weight inputs
        Box(modifier = Modifier
            .weight(2f)
            .fillMaxWidth()){
            
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


@Composable
fun Graph(
    modifier: Modifier,
    xValues: List<Int>,
    yValues: List<Int>,
    points: List<Float>,
    paddingSpace: Dp,
    VerticalStep:Int
){
    Box(
        modifier = modifier
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.fillMaxWidth()){

        }
    }
}


@Preview
@Composable
fun DashboardViewPreview(){
    DashBoardView(navController = rememberNavController())
}