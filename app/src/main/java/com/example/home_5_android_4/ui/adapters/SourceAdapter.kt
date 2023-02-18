package com.example.home_5_android_4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.home_4_android_4.databinding.ItemSourceBinding
import com.example.home_5_android_4.data.models.source.SourcesItem

class SourceAdapter : ListAdapter<SourcesItem, SourceAdapter.SourceViewHolder>(diffUtil) {

    inner class SourceViewHolder(private val binding: ItemSourceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: SourcesItem) = with(binding) {
            txtNameSource.text = item.name
            txtDescriptionSource.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        return SourceViewHolder(
            ItemSourceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<SourcesItem>() {

            override fun areItemsTheSame(oldItem: SourcesItem, newItem: SourcesItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: SourcesItem, newItem: SourcesItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}