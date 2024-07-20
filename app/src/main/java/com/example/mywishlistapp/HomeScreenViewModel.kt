package com.example.mywishlistapp
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Graph
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
) : ViewModel() {
    private var _titleText  =
        mutableStateOf("")

    private var _descText  =
        mutableStateOf("")

    var titleText = _titleText
    var descText = _descText

    fun onUpdateTitleText(text : String){
        _titleText.value = text
    }

    fun onUpdateDescText(text :String){
        _descText.value = text
    }

    lateinit var allWishes : Flow<List<Wish>>
    init {
        viewModelScope.launch {
            allWishes =  wishRepository.getWishes()
        }
    }
    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun deletWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }

    fun getAWish(id:Long) : Flow<Wish>{
        return wishRepository.getAWish(id)
    }
}