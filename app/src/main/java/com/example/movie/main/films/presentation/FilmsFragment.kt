package com.example.movie.main.films.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.databinding.FragmentFilmsBinding
import com.google.android.material.tabs.TabLayout

const val FILMS_PAGES_COUNT = 2
class FilmsFragment : BaseFragment() {

    companion object {
        const val TAG = "FilmsFragment"

        fun newInstance() = FilmsFragment()
    }

    lateinit var binding: FragmentFilmsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_films, container, false)
        initPagerAdapter()

        return binding.root
    }

    private fun initPagerAdapter(){
        binding.vpFilms.adapter = FilmsPagerAdapter(childFragmentManager, FILMS_PAGES_COUNT)
        binding.vpFilms.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabFilms))
        addTabNames()
    }

    private fun addTabNames(){
        binding.tabFilms.addTab(binding.tabFilms.newTab().setText(R.string.films_tab_popular))
        binding.tabFilms.addTab(binding.tabFilms.newTab().setText(R.string.films_tab_soon_on))
    }


}
