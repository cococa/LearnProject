package com.cocoa.testjetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cocoa.testjetpack.R
import com.cocoa.testjetpack.bean.MainItem

class MainItemAdapter(private val onClick: (MainItem) -> Unit) :
    ListAdapter<MainItem, MainItemAdapter.MainItemViewHolder>(MainItemDiffCallback) {


    class MainItemViewHolder(itemView: View, onClick: (MainItem) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private var mMainItem: MainItem? = null;
        private var name: TextView = itemView.findViewById(R.id.text1);

        init {
            itemView.setOnClickListener {
                mMainItem?.let {
                    onClick(it)
                }
            }
        }

        fun bindItem(mainItem: MainItem?) {
            this.mMainItem = mainItem
            name.text = mainItem?.name ?: "123"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_main, parent, false)
        return MainItemViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        val mainItem = getItem(position)
//        currentList[position]
        holder.bindItem(mainItem);
    }


}


object MainItemDiffCallback : DiffUtil.ItemCallback<MainItem>() {
    override fun areItemsTheSame(oldItem: MainItem, newItem: MainItem): Boolean {
        return oldItem == newItem;
    }

    override fun areContentsTheSame(oldItem: MainItem, newItem: MainItem): Boolean {
        return oldItem.name.equals(newItem.name)
    }


    override fun getChangePayload(oldItem: MainItem, newItem: MainItem): Any? {
        return super.getChangePayload(oldItem, newItem)
    }

}