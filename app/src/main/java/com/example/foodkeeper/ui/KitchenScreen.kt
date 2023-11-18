package com.example.foodkeeper.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodkeeper.R
import com.example.foodkeeper.ui.theme.Black
import com.example.foodkeeper.ui.theme.FoodKeeperGreen
import com.example.foodkeeper.ui.theme.FoodKeeperTheme
import com.example.foodkeeper.ui.theme.MidGrey
import com.example.foodkeeper.ui.theme.Orange
import com.example.foodkeeper.ui.theme.Red
import com.example.foodkeeper.ui.theme.White


class KitchenScreen : ComponentActivity() {
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
                                item{Row (modifier = Modifier.fillMaxWidth()){
                                    Categories(category = "Fridge", icon = fridge)
                                }}
                                item {ItemCard(itemImage = Salmon, item = "Salmon", weight = 100, days = 2, quantity = 1, modifier = Modifier)}
                                item {ItemCard(itemImage = Yogurt, item = "Yogurt", weight = 100, days = 7, quantity = 1, modifier = Modifier)}
                                item {ItemCard(itemImage = capsicum, item = "Capsicum", weight = 500, days = 20, quantity = 3, modifier = Modifier)}
                                item{Row (modifier = Modifier.fillMaxWidth()){
                                    Categories(category = "Pantry", icon = pantry)
                                }}
                            }

                        }
                    }
            }
        }
    }
}

data class Person(val name: String, val age: Int)
data class FoodItem(val name: String, val weight: Int, val quantity: Int, val expiryDate: Int, val storageType: String)


@Composable
fun GreetingBanner(name: String, message: String, modifier: Modifier = Modifier) {
    val profileIcon = painterResource(R.drawable.boy)
    Box(modifier = Modifier
        .fillMaxWidth()
        .size(width = 65.dp, height = 140.dp) //this width is redundant
        .clip(shape = RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp))
        .background(FoodKeeperGreen)
    ){
        Row (modifier = Modifier
            .padding(top = 40.dp)
            .align(alignment = Alignment.Center)
        ){
            Column(){
                Text(
                    text = "Hey $name,",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = message,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(140.dp))
            Image(
                painter = profileIcon,
                contentDescription = "profile icon",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(color: Color, modifier: Modifier = Modifier) {
    var food by remember { mutableStateOf("") }
    val barcodeIcon = painterResource(R.drawable.barcode)
    val plusIcon = painterResource(R.drawable.plus_icon)
    TextField(
        value = food,
        onValueChange = { food = it },
        label = { Text(text ="What's in my kitchen") },
        shape = RoundedCornerShape(40.dp),
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search")},
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            .width(270.dp)
            .height(40.dp)
            .shadow(4.dp, shape = RoundedCornerShape(40.dp)),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            cursorColor = color,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}

//@Composable
//fun ExpandableListItem(expanded: Boolean, onClick: () -> Unit) {
//    val collapseIcon: ImageVector = vectorResouorce(id = R.drawable.collapse_icon)
//    val uncollapsedArrow: ImageVector = vectorResource(id = R.drawable.uncollapsed_arrow)
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable { onClick() }
//    ) {
//        Icon(
//            imageVector = if (expanded) collapseIcon else uncollapsedArrow,
//            contentDescription = "Toggle",
//            modifier = Modifier.size(24.dp) // Adjust the size as needed
//        )
//        Text(text = "Expandable Item")
//    }
//}

@Composable //category heading
fun Categories(category: String, icon: Painter,){
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
//            .clickable { onHeaderClicked() }
            .padding(bottom = 5.dp)){
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .padding(start = 10.dp, end = 4.dp),
            tint = Color.Unspecified
        )
        Text(
            text = "My $category",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
//        if (isExpanded) {
//            Icon(painter = painterResource(id = R.drawable.collapse_icon), contentDescription = "collapse section", modifier = Modifier.padding(start = 4.dp))
//        } else {
//            Icon(painter = painterResource(id = R.drawable.uncollapsed_arrow), contentDescription = "expand section", modifier = Modifier.padding(start = 4.dp))
//        }

    }
}


@Composable
fun ItemCard(itemImage: Painter, item: String, weight: Int, days: Int, quantity: Int, modifier: Modifier) {
    val upArrow = painterResource(R.drawable.up_arrow)
    val downArrow = painterResource(R.drawable.down_arrow)
    val foodKeeperRed = Color(0xFFFE6262)
    val MidGrey = Color(0xFFCECECE)
    val DarkGrey = Color(0xFF7E7E7E)
    val foodKeeperOrange = Color(0xFFFF9649)
    OutlinedCard(colors = CardDefaults.cardColors(containerColor = White,),
                 border = BorderStroke(1.dp, MidGrey),
                 modifier = Modifier
                     .size(width = 354.dp, height = 60.dp)
                     .fillMaxWidth()
                     .padding(top = 4.dp, bottom = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(9.dp))
            Image(
                painter = itemImage,
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.spacedBy((-3).dp), modifier = Modifier.width(120.dp)) {
                Text(text = item,
                     fontWeight = FontWeight.Bold,
                     fontSize = 16.sp)
                Text(text = "$weight g",
                    color = DarkGrey,
                    fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(width = 65.dp, height = 25.dp)
                    .clip(shape = RoundedCornerShape(12.dp, 12.dp, 12.dp, 12.dp))
                    .background(
                        if (days in 4..7) {
                            foodKeeperOrange
                        } else if (days < 3) {
                            foodKeeperRed
                        } else {
                            Color.White
                        }
                    )
            ) {
                Text(
                    text = "$days days",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.width(18.dp))
            Column (){
                Image(painter = upArrow, contentDescription = null)
                Text(text = "$quantity")
                Image(painter = downArrow, contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KitchenScreenPreview() {
    FoodKeeperTheme {
        // A surface container using the 'background' color from the theme
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
                        item{Row (modifier = Modifier.fillMaxWidth()){
                            Categories(category = "Fridge", icon = fridge)
                        }}
                        item {ItemCard(itemImage = Salmon, item = "Salmon", weight = 100, days = 2, quantity = 1, modifier = Modifier)}
                        item {ItemCard(itemImage = Yogurt, item = "Yogurt", weight = 100, days = 7, quantity = 1, modifier = Modifier)}
                        item {ItemCard(itemImage = capsicum, item = "Capsicum", weight = 500, days = 20, quantity = 3, modifier = Modifier)}
                        item{Row (modifier = Modifier.fillMaxWidth()){
                            Categories(category = "Pantry", icon = pantry)
                        }}
                    }

                }
            }
        }

}






