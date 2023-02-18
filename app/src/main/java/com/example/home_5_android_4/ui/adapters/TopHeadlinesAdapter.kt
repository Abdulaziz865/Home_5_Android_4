package com.example.home_5_android_4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home_4_android_4.databinding.ItemTopHeadlinesBinding
import com.example.home_5_android_4.data.models.news.ArticlesItem

class TopHeadlinesAdapter :
    ListAdapter<ArticlesItem, TopHeadlinesAdapter.TopHeadlinesViewHolder>(diffUtil) {

    inner class TopHeadlinesViewHolder(private val binding: ItemTopHeadlinesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: ArticlesItem) = with(binding) {
            Glide.with(imageTopHeadlines.context).load(item.urlToImage).into(imageTopHeadlines)
            txtNameTopHeadlines.text = item.source.name
            txtDescriptionTopHeadlines.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        return TopHeadlinesViewHolder(
            ItemTopHeadlinesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
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