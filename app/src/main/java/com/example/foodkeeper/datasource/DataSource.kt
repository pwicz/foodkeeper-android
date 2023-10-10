package com.example.foodkeeper.datasource

import com.example.foodkeeper.R
import com.example.foodkeeper.model.BottomNavigationItem

object DataSource {

    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            title = "Kitchen",
            selectedIcon = R.drawable.fridge,
            unselectedIcon = R.drawable.fridge,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Shopping",
            selectedIcon = R.drawable.shopping_cart,
            unselectedIcon = R.drawable.shopping_cart,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Recipe",
            selectedIcon = R.drawable.book,
            unselectedIcon = R.drawable.book,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Discover",
            selectedIcon = R.drawable.earth,
            unselectedIcon = R.drawable.earth,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = R.drawable.profile,
            unselectedIcon = R.drawable.profile,
            hasNews = false
        ),
        // add more
    )
}