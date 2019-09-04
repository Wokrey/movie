package com.example.movie.main.films.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.databinding.FragmentSoonOnBinding


class SoonOnFragment : BaseFragment() {

    companion object{
        const val TAG = "SoonOnFragment"

        fun newInstance() = SoonOnFragment()
    }

    lateinit var binding: FragmentSoonOnBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_soon_on, container, false)

        return binding.root
    }


}
