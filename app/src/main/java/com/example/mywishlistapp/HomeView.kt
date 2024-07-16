package com.example.mywishlistapp
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mywishlistapp.data.DummyWish
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.ui.theme.MyWishlistAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    viewModel: HomeScreenViewModel,
    navController: NavController
){
    val context = LocalContext.current

   Scaffold(
       topBar =  {
           AppBarView(title = "WishListApp") {
               Toast.makeText(context, "Button clickable", Toast.LENGTH_LONG).show()
           }
       },
       floatingActionButton = {
           FloatingActionButton(onClick = {
               navController.navigate(Screen.AddScreen.route)

           }, modifier = Modifier.padding(20.dp),
               contentColor = Color.White,
               containerColor = Color.Black
               ) {
               Icon(
                   imageVector = Icons.Default.Add,
                   tint = Color.White,
                   contentDescription = ""
               )
           }
       }
   ) {
       LazyColumn(modifier = Modifier
           .fillMaxSize()
           .padding(it),
           ){
           items(DummyWish.wishList){
               wish -> wishItem(wish = wish) {

           }
           }
       }
   }
}

@Composable
fun wishItem(wish : Wish, onClick : () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 10.dp
            )
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            focusedElevation = 14.dp

        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(wish.title, fontWeight = FontWeight.ExtraBold)
            Text(wish.desc, fontWeight = FontWeight.ExtraBold)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    MyWishlistAppTheme {
//        HomeView()
    }
}



