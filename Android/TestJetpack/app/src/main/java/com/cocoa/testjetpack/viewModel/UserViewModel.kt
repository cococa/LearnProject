package com.cocoa.testjetpack.viewModel

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cocoa.testjetpack.bean.User
import java.util.concurrent.Flow




class UserViewModel : ViewModel() {






    private val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>().also {
            loadUser()
        }
    }


    fun getUser() :LiveData<User> {
        Log.i("UserViewModel", "getUser ${user.value}")
        return user
    }


    fun loadUser(){
        Thread{
            user.postValue(User("shen","cocoa"))
        }.start()
    }


    fun setUser(u : User){
        user.value = u
    }

}