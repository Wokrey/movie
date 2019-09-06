package com.example.movie.main.genres.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.movie.main.genres.genre.GenreMoviesFragment

/**
 * Created by wokrey@gmail.com on 9/6/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

class GenresPagerAdapter(
    fm: FragmentManager,
    private val idList: List<Int>
): FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment  = GenreMoviesFragment.newInstance(id = idList[position])

    override fun getCount(): Int = idList.size

}