package com.example.mywishlistapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mywishlistapp.data.DummyWish
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.ui.theme.MyWishlistAppTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(viewModel: HomeScreenViewModel, wish : Wish, navController: NavController){

    Scaffold(
        topBar = {
            AppBarView(title = if(wish.id==0L) stringResource(id = R.string.add_screen)else stringResource(
                id = R.string.update_screen
            )) {
                navController.navigateUp()
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .wrapContentSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.height(10.dp))
            WishPageTextField(label = "Title",
                value = viewModel.titleText.value, onChangeValueBack ={
                    text ->
                    viewModel.onUpdateTitleText(text)
                } )
            Spacer(modifier = Modifier.height(20.dp))

            WishPageTextField(label = "Description",
                value = viewModel.descText.value, onChangeValueBack ={
                        text ->
                    viewModel.onUpdateDescText(text)
                } )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                if(viewModel.titleText.value.isNotEmpty() &&
                    viewModel.descText.value.isNotEmpty()){
                    DummyWish.wishList.add(
                        Wish(
                            1,
                            viewModel.titleText.value,
                            viewModel.descText.value
                        )
                    )
                    navController.navigateUp()
                }else{

                }
            }) {
                Text(if(wish.id==0L) stringResource(id = R.string.add_screen)else stringResource(
                    id = R.string.update_screen
                ))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishPageTextField(label:String,value: String,
                      onChangeValueBack: (String)-> Unit){
    OutlinedTextField(value = value,
        onValueChange = onChangeValueBack,
        label = {
            Text(text = label, color = Color.Black)
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AddScreenView() {
    val homeScreenViewModel : HomeScreenViewModel = viewModel()
    val wishData = Wish(1, "pdcs", "vdf")
    MyWishlistAppTheme {


        AddScreen(homeScreenViewModel, wishData, rememberNavController())
    }
}