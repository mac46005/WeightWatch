package com.preciado.weightwatch.features.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavController

@Composable
fun DashBoardView(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavController
){
    Column (modifier = modifier){
        
        //This will show a graph of all(or maybe from date to date) weight inputs
        Box(modifier = Modifier){
            
        }
        //Shows relevant info such as weight average and eating habits
        Card(modifier = Modifier) {
            
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