package com.example.movie.main.films.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by wokrey@gmail.com on 9/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class FilmsPagerAdapter(
    fm: FragmentManager,
    private val pagesCount: Int = 0
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> PopularFragment.newInstance()
        else -> UpcomingFragment.newInstance()
    }

    override fun getCount() = pagesCount
}