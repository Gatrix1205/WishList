package com.example.mywishlistapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {
    private var _titleText  =
        mutableStateOf("")

    private var _descText  =
        mutableStateOf("")

    var titleText : State<String> = _titleText
    var descText : State<String> = _descText

    fun onUpdateTitleText(text : String){
        _titleText.value = text
    }

    fun onUpdateDescText(text :String){
        _descText.value = text
    }
}