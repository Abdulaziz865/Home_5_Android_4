package com.example.home_5_android_4.ui.fragments.topheadlines

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_4_android_4.R
import com.example.home_4_android_4.databinding.FragmentTopHeadlinesBinding
import com.example.home_5_android_4.base.BaseFragment
import com.example.home_5_android_4.ui.adapters.TopHeadlinesAdapter
import com.example.home_5_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment : BaseFragment<FragmentTopHeadlinesBinding ,
        TopHeadlinesViewModel>(R.layout.fragment_top_headlines
) {

    override val binding by viewBinding(FragmentTopHeadlinesBinding::bind)
    override val viewModel: TopHeadlinesViewModel by viewModels()
    private val topHeadlinesAdapter = TopHeadlinesAdapter()

    override fun initialize() = with(binding) {
        rvTopHeadlines.adapter = topHeadlinesAdapter
    }

    override fun setupSubscribes() {
        setupToTopHeadlines()
    }

    private fun setupToTopHeadlines() {
        viewModel.fetchTopHeadlines("us").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let {
                        topHeadlinesAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}