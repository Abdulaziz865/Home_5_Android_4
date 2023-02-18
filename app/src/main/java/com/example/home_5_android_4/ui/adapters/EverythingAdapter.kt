package com.example.home_5_android_4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home_4_android_4.databinding.ItemEverythingBinding
import com.example.home_5_android_4.data.models.news.ArticlesItem

class EverythingAdapter :
    ListAdapter<ArticlesItem, EverythingAdapter.EverythingViewHolder>(diffUtil) {

    inner class EverythingViewHolder(private val binding: ItemEverythingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: ArticlesItem) = with(binding) {
            Glide.with(imageEverything.context).load(item.urlToImage).into(imageEverything)
            txtNameEverything.text = item.source.name
            txtDescriptionEverything.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EverythingViewHolder {
        return EverythingViewHolder(
            ItemEverythingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EverythingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ArticlesItem>() {

            override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}