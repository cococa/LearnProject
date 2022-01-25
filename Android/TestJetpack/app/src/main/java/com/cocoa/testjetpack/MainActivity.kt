package com.cocoa.testjetpack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cocoa.testjetpack.adapter.MainItemAdapter
import com.cocoa.testjetpack.bean.MainItem
import com.cocoa.testjetpack.databinding.ActivityMainBinding
import com.cocoa.testjetpack.view.ViewModelActivity

class MainActivity : AppCompatActivity() {

    val mMianItemList = listOf<MainItem>(
        MainItem("ViewModel", clazz = ViewModelActivity::class.java),
        MainItem("item2", clazz = MainActivity::class.java)
    );
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val mMainItemAdapter = MainItemAdapter {
            println(it);
            startActivity(Intent(this, it.clazz))
        }

        binding?.mRecyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.mRecyclerView?.adapter = mMainItemAdapter
        mMainItemAdapter.submitList(mMianItemList)

    }
}
