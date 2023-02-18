package com.example.home_5_android_4.ui.fragments.everything

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.home_4_android_4.R
import com.example.home_4_android_4.databinding.FragmentEverythingBinding
import com.example.home_5_android_4.base.BaseFragment
import com.example.home_5_android_4.ui.adapters.EverythingAdapter
import com.example.home_5_android_4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingFragment : BaseFragment<FragmentEverythingBinding,
        EverythingViewModel>(
    R.layout.fragment_everything
) {

    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val everythingAdapter = EverythingAdapter()

    override fun initialize() = with(binding) {
        rvEverything.adapter = everythingAdapter
    }

    override fun setupSubscribes() {
        setupToBitcoin()
    }

    private fun setupToBitcoin() {
        viewModel.fetchEverything("bitcoin").observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let {
                        everythingAdapter.submitList(it.articles)
                    }
                }
            }
        }
    }
}