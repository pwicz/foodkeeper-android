package com.example.foodkeeper.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodkeeper.ui.theme.FoodKeeperTheme

@Composable
fun ScannedScreen(name: String) {
    Column (
        modifier = Modifier.fillMaxSize(),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Scan again")
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodKeeperTheme {
        ScannedScreen(name = "Greeting")
    }

}