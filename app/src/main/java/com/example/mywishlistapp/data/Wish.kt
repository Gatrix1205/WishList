package com.example.mywishlistapp.data



data class Wish(
    var id : Long = 0L,
    var title : String,
    var desc : String

)

object DummyWish{
    val wishList = mutableListOf(
        Wish(title = "Pixel 7A", desc = "Wow! Wonderful"),
        Wish(title = "Pixel 7A", desc = "Wow! Wonderful"),
        Wish(title = "Pixel 7A", desc = "Wow! Wonderful"),
    )
}
