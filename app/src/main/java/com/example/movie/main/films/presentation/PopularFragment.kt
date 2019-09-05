package com.example.movie.main.films.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.databinding.FragmentPopularBinding
import com.example.movie.main.films.domain.PopularViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularFragment : BaseFragment() {

    companion object{
        const val TAG = "PopularFragment"

        fun newInstance() = PopularFragment()
    }

    lateinit var binding: FragmentPopularBinding
    private val viewModel: PopularViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
        viewModel.loadPopulars()
        return binding.root
    }


}
