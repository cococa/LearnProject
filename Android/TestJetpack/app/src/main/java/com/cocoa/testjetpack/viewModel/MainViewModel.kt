package com.cocoa.testjetpack.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cocoa.testjetpack.bean.User
import com.cocoa.testjetpack.storage.room.AppDatabase

class MainViewModel : ViewModel() {

    val user: User = User("MainViewModel", "MainViewModel")
//    val db: AppDatabase = AppDatabase.getInstance(applicationContext);

    //    注意：请确保用于更新界面的 LiveData 对象存储在 ViewModel 对象中，而不是将其存储在 Activity 或 Fragment 中，原因如下：
//    避免 Activity 和 Fragment 过于庞大。现在，这些界面控制器负责显示数据，但不负责存储数据状态。
//    将 LiveData 实例与特定的 Activity 或 Fragment 实例分离开，并使 LiveData 对象在配置更改后继续存在。
    var currentName: MutableLiveData<String> = MutableLiveData<String>("")

    val currentAge: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }


}
