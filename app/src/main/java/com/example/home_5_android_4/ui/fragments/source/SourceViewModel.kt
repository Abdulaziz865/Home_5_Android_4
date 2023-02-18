package com.example.home_5_android_4.ui.fragments.source

import com.example.home_5_android_4.base.BaseViewModel
import com.example.home_5_android_4.data.repositories.SourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(private val repository : SourceRepository): BaseViewModel() {

    fun fetchSource(newQ : String) = repository.fetchSource(newQ)
}