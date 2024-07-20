package com.example.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao){

    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }

     fun getWishes() = wishDao.getAllWishes()

    suspend fun updateWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }

     fun getAWish(id: Long) : Flow<Wish> {
        return wishDao.getWishesById(id)
    }

}