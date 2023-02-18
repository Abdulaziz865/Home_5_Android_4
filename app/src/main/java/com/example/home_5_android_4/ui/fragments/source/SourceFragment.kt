package com.example.home_5_android_4.ui.fragments.source

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_4_android_4.R
import com.example.home_4_android_4.databinding.FragmentSourceBinding
import com.example.home_5_android_4.base.BaseFragment
import com.example.home_5_android_4.ui.adapters.SourceAdapter
import com.example.home_5_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceFragment : BaseFragment<FragmentSourceBinding , SourceViewModel>(R.layout.fragment_source) {

    override val binding by viewBinding(FragmentSourceBinding::bind)
    override val viewModel: SourceViewModel by viewModels()
    private val sourceAdapter = SourceAdapter()

    override fun initialize() = with(binding) {
        rvSource.adapter = sourceAdapter
    }

    override fun setupSubscribes() {
        setupToTopHeadlines()
    }

    private fun setupToTopHeadlines() {
        viewModel.fetchSource("news").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let {
                        sourceAdapter.submitList(it.sources)
                    }
                }
            }
        }
    }
}