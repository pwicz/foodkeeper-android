package com.example.foodkeeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodkeeper.ui.Categories
import com.example.foodkeeper.ui.GreetingBanner
import com.example.foodkeeper.ui.ItemCard
import com.example.foodkeeper.ui.SearchBar
import com.example.foodkeeper.ui.theme.FoodKeeperTheme

class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FoodKeeperTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FoodKeeperTheme {
//        Greeting("Android")
//    }
//}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodKeeperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(){
                        GreetingBanner(name = "Piotr", message = "Let's get cooking!", modifier = Modifier)
                        Row (verticalAlignment = Alignment.CenterVertically){
                            SearchBar(color = Color(0xADADAD))
                            Spacer(modifier = Modifier.width(10.dp))
                            val barcodeIcon = painterResource(R.drawable.barcode)
                            val plusIcon = painterResource(R.drawable.plus_icon)
                            Icon(painter = plusIcon, contentDescription = "Add item", modifier = Modifier
                                .size(34.dp)
                                .padding()
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(painter = barcodeIcon, contentDescription = "Scan item", modifier = Modifier
                                .size(34.dp)
                            )
                        }
                        val fridge = painterResource(R.drawable.fridge)
                        val Salmon = painterResource(R.drawable.salmon)
                        val Yogurt = painterResource(R.drawable.yogurt)
                        val capsicum = painterResource(R.drawable.capsicum)
                        val pantry = painterResource(R.drawable.pantry)
                        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()){
                            item{
                                Row (modifier = Modifier.fillMaxWidth()){
                                Categories(category = "Fridge", icon = fridge)
                            }
                            }
                            item { ItemCard(itemImage = Salmon, item = "Salmon", weight = 100, days = 2, quantity = 1, modifier = Modifier) }
                            item { ItemCard(itemImage = Yogurt, item = "Yogurt", weight = 100, days = 7, quantity = 1, modifier = Modifier) }
                            item { ItemCard(itemImage = capsicum, item = "Capsicum", weight = 500, days = 20, quantity = 3, modifier = Modifier) }
                            item{
                                Row (modifier = Modifier.fillMaxWidth()){
                                Categories(category = "Pantry", icon = pantry)
                            }
                            }
                        }

                    }
                }
            }
        }
    }
}