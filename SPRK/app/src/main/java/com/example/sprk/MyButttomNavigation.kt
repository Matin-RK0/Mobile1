package com.example.sprk


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable

fun MyBottomNavigation(navController: NavController){
    val destonationList = listOf<Destinations>( Login , welcome)
    val selectedIndex = rememberSaveable{
        mutableStateOf(0)
    }
    BottomNavigation() {
        destonationList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = {Text(text = destinations.title )},
                icon = { Icon(imageVector = destinations.icon, contentDescription = destinations.title) },
                selected = index==selectedIndex.value ,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destonationList[index].Route){
                        popUpTo(Login.Route)
                        launchSingleTop = true
                    }
                })
        }
    }
}
