package com.example.home_5_android_4.ui.fragments.everything

import com.example.home_5_android_4.base.BaseViewModel
import com.example.home_5_android_4.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val repository: EverythingRepository): BaseViewModel(){

    fun fetchEverything(newQ : String) = repository.fetchEverything(newQ)
}