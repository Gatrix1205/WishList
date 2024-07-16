package com.example.mywishlistapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.mywishlistapp.data.Wish

@Composable
fun NavigationHome(homeScreenViewModel: HomeScreenViewModel = viewModel(),
                   navHostController: NavHostController =  rememberNavController()){
    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeView(homeScreenViewModel, navHostController)
        }
        composable(Screen.AddScreen.route){
            AddScreen(viewModel = homeScreenViewModel, wish = Wish(
                0L, " ", ""
            ), navHostController )
        }
    }
}