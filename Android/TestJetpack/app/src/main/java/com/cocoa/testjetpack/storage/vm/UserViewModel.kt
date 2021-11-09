package com.cocoa.testjetpack.storage.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cocoa.testjetpack.storage.room.User
import com.cocoa.testjetpack.storage.room.UserDao
import kotlinx.coroutines.flow.Flow

class UserViewModel(val userDao: UserDao): ViewModel() {


    var user = MutableLiveData<List<User>>()

    fun setUser(users : List<User>){
        user.postValue(users)
    }

    fun getAllUser() : Flow<List<User>> = userDao.getAllUser();

}


class UserViewModelFactory(val userDao: UserDao) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return UserViewModel(userDao) as T
    }
}

