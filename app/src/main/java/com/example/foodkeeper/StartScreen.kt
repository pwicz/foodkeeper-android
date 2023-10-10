package com.example.foodkeeper

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodkeeper.datasource.DataSource
import com.example.foodkeeper.ui.theme.FoodKeeperTheme

enum class FoodKeeperScreen() {
    Kitchen(),
    Shopping(),
    Recipe(),
    Discover(),
    Profile()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodKeeperApp(
    navController: NavHostController = rememberNavController()
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val poppinsFamily = FontFamily(
        Font(R.font.poppins, FontWeight.Normal)
    )

    /* Should be added to colors file */
    val colorSelected = Color(0xFF046229)
    val colorDefault = Color(0xFF686666)

    Scaffold (
        bottomBar = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                DataSource.bottomNavigationItems.forEachIndexed { index, item ->
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                selectedItemIndex = index
                            }
                            .padding(top = 8.dp, bottom = 8.dp)
                    ){
                        BadgedBox(badge = {
                            if(item.hasNews) {
                                Badge()
                            }
                        }) {
                            val icon = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(32.dp),
                                tint = if (selectedItemIndex == index) colorSelected else colorDefault
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = item.title,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = if (selectedItemIndex == index) colorSelected else colorDefault
                        )
                    }
                }
            }
        }
    ){
        innerPadding ->

        NavHost(
            navController = navController,
            startDestination = FoodKeeperScreen.Kitchen.name,
        ) {
            composable(route = FoodKeeperScreen.Kitchen.name) {
                // Kitchen screen goes here
            }
            composable(route = FoodKeeperScreen.Shopping.name) {
                // Shopping screen goes here
            }
            composable(route = FoodKeeperScreen.Recipe.name) {
                // Recipe screen goes here
            }
            composable(route = FoodKeeperScreen.Discover.name) {
                // Discover screen goes here
            }
            composable(route = FoodKeeperScreen.Profile.name) {
                // Profile screen goes here
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    FoodKeeperTheme {
        FoodKeeperApp()
    }
}