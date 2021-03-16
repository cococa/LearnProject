package com.cocoa.testjetpack.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cocoa.testjetpack.bean.User

class MainViewModel : ViewModel() {

    val user: User = User("MainViewModel", "MainViewModel")

    override fun onCleared() {
        super.onCleared()
    }


    var currentName : MutableLiveData<String> =   MutableLiveData<String>("")


}
