package com.example.home_5_android_4.ui.fragments.topheadlines

import com.example.home_5_android_4.base.BaseViewModel
import com.example.home_5_android_4.data.repositories.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(private val repository : TopHeadlinesRepository) : BaseViewModel() {

    fun fetchTopHeadlines(newQ : String) = repository.fetchTopHeadlines(newQ)
}