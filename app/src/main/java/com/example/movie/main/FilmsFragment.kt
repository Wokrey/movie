package com.example.movie.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.base.BaseFragment


class FilmsFragment : BaseFragment() {

    companion object{
        const val TAG = "FilmsFragment"

        fun newInstance() = FilmsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_films, container, false)
    }


}
