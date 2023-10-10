package com.example.foodkeeper.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodkeeper.R
import com.example.foodkeeper.ui.theme.FoodKeeperTheme

@Composable
fun ShoppingScreenMain() {
Column (
    horizontalAlignment = Alignment.End,
    verticalArrangement = Arrangement.Top,
    modifier = Modifier
        .fillMaxWidth()
        .padding(30.dp)
        .padding(end = 8.dp)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ios_share),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.__dots_icon),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .padding(start = 8.dp)
        )
    }
}
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
    ) {
        Text(
            text = "Shopping List",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(46.dp))
        SearchBar()
        SortBy()
        ShoppingListMenu()
    }
}
@Composable
fun SearchBar() {
//    val image = painterResource()
    val colors = Color.LightGray
        Box(
            modifier = Modifier
                .size(235.dp, 50.dp)
                .background(colors, RoundedCornerShape(16.dp))
                .padding(top = 8.dp),
            contentAlignment = Alignment.Center
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                Image (
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 17.dp)
                        .padding(top = 4.dp)
                        .padding(bottom = 17.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 2.dp) // Indent to the left
                ) {
                    Text(
                        text = "Search for shopping list",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 5.dp)
                    )
                    Text(
                        text = "sort by",
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
@Composable
fun SortBy() {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 93.dp)
            .padding(top = 5.dp)
    ){
        Text(
            text = "sort by",
            color = Color.Black,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun ShoppingListMenu() {
    val colors = Color.White

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        items(6) { index ->
            Box(
                modifier = Modifier
                    .size(280.dp, 60.dp)
                    .border(1.dp, Color.Green, RoundedCornerShape(16.dp))
                    .background(colors, RoundedCornerShape(16.dp)),
            ) {
                Text(
                    text = "Shopping List $index", // Your text here
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .padding(top = 10.dp)
                )
                Text(
                    text = "Description",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .padding(top = 30.dp)
                    )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingScreenMainPreview() {
    FoodKeeperTheme {
        ShoppingScreenMain()
    }
}
