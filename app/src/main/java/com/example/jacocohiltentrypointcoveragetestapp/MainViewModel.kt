package com.example.jacocohiltentrypointcoveragetestapp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor() : ViewModel() {
    fun onButtonPress() = Unit
}
