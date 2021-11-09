package com.cocoa.testjetpack.storage

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.cocoa.testjetpack.TestApplication
import com.cocoa.testjetpack.databinding.ActivityStorageBinding
import com.cocoa.testjetpack.storage.room.AppDatabase
import com.cocoa.testjetpack.storage.room.User
import com.cocoa.testjetpack.storage.vm.UserViewModel
import com.cocoa.testjetpack.storage.vm.UserViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


//https://github.com/google-developer-training/android-basics-kotlin-bus-schedule-app
class StorageActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityStorageBinding
    var db: AppDatabase? = null
    val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(
            (application as TestApplication).database.userDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(applicationContext);

        setSupportActionBar(binding.toolbar)

        userViewModel.user.observe(this) {
            val msg = it.toString();
            binding?.tv1?.text = msg
        }

        binding?.btn1?.setOnClickListener {
            getDatabase()
        }
        binding?.btn2?.setOnClickListener {
            getDatabaseVersion2()
        }

    }


    fun getDatabaseVersion2() {
        GlobalScope.launch(Dispatchers.IO) {
            userViewModel.getAllUser().collect {
                println(" getDatabaseVersion2  ${it}")
            }
        }
    }


    fun getDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            db?.userDao()?.insertUser(User(null, "cocoa", 12, ""))
            val users = db?.userDao()?.getAllUser()
            users?.collect {
                userViewModel.setUser(it);
            }

        }
    }


}