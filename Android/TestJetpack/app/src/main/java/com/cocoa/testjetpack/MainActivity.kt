package com.cocoa.testjetpack

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArrayMap
import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.cocoa.testjetpack.bean.Handler
import com.cocoa.testjetpack.bean.User
import com.cocoa.testjetpack.databinding.ActivityMainBinding
import com.cocoa.testjetpack.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {


    val mainViewModel: MainViewModel by viewModels()
    var binding: ActivityMainBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
//        binding?.user = User("sj","jun")
//        binding?.defaultStr = "the default String"
//        binding?.handler = Handler()
        setContentView(binding?.root)

        binding?.user = mainViewModel.user
        binding?.defaultStr = "the default String"


        mainViewModel?.currentName.observe(this, nameObserver)
        binding?.btn1?.setOnClickListener {
            changeName()
        }


    }

    val nameObserver = Observer<String> { newName ->
        // Update the UI, in this case, a TextView.
        binding?.text1?.text = newName
    }


    fun changeName() {
        mainViewModel?.currentName.value = "123"
    }

}
