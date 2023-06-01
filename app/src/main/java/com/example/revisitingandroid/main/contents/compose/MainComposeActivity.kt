package com.example.revisitingandroid.main.contents.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.compose.model.BottomBarItem
import com.example.revisitingandroid.main.contents.compose.model.Menu
import com.example.revisitingandroid.main.contents.compose.model.dummyBestSellerMenu
import com.example.revisitingandroid.main.contents.compose.model.dummyCategory
import com.example.revisitingandroid.main.contents.compose.model.dummyMenu
import com.example.revisitingandroid.main.contents.compose.ui.components.CategoryItem
import com.example.revisitingandroid.main.contents.compose.ui.components.HomeSection
import com.example.revisitingandroid.main.contents.compose.ui.components.MenuItem
import com.example.revisitingandroid.main.contents.compose.ui.components.SearchBar
import com.example.revisitingandroid.main.contents.compose.ui.theme.RevisitingAndroidTheme

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RevisitingAndroidTheme {
                JetCoffeApp()
            }

        }
    }
}

@Composable
fun JetCoffeApp()
{
    Scaffold(
        bottomBar = { BottomBar() }
    ){

        Column(modifier = Modifier.verticalScroll(rememberScrollState()).padding(it)) {
            Banner()
            HomeSection(stringResource(R.string.section_category),
                content= { CategoryRow() } )
            HomeSection(stringResource(R.string.section_favorite_menu),Modifier) {
                MenuRow(dummyMenu)
            }
            HomeSection(stringResource(R.string.section_best_seller_menu), Modifier) {
                MenuRow(dummyBestSellerMenu)
            }

        }
    }



}

@Composable
fun Banner(
    modifier : Modifier = Modifier) {

    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}


@Composable
fun CategoryRow(modifier : Modifier = Modifier)
{
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal=16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = {it.textCategory}) {category ->
            CategoryItem(category)
        }
    }
}
@Composable
@Preview(showBackground = true)
fun CategoryRowPreview()
{
    RevisitingAndroidTheme {
        CategoryRow()
    }

}

@Composable
fun MenuRow(
    listMenu : List<Menu>,
    modifier : Modifier = Modifier
)
{
    LazyRow(
        horizontalArrangement =  Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(listMenu, key = {it.title}) {menu->
            MenuItem(menu)
        }
    }
}

@Composable
fun BottomBar( modifier : Modifier = Modifier )
{
    BottomNavigation(modifier =modifier)
    {
        val navigationItems : List<BottomBarItem> = listOf(

            BottomBarItem(title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home),
            BottomBarItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite),
            BottomBarItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            )

        )

        navigationItems.map {

            BottomNavigationItem(

                icon =  { Icon(imageVector = it.icon, contentDescription = it.title) },
                label = { Text(it.title) },
                selected = it.title == navigationItems[0].title,
                onClick = {}

            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun JetCoffeAppPreview() {
    JetCoffeApp()
}