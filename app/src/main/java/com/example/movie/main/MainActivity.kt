package com.example.movie.main

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.movie.R
import com.example.movie.base.BaseActivity
import com.example.movie.main.films.presentation.FilmsFragment
import com.example.movie.main.genres.presentation.GenresFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener
    private var currentTag: String = FilmsFragment.TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavListener()
        if (savedInstanceState == null) {
            replaceFragment(R.id.current_menu_container, FilmsFragment.newInstance(), currentTag)
        }
    }

    private fun initNavListener() {

        navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            onBottomNavigationSelected(id = item.itemId)

            var selectedFragment = supportFragmentManager.findFragmentByTag(currentTag)

            if (selectedFragment == null) {
                selectedFragment = when (currentTag) {
                    FilmsFragment.TAG -> FilmsFragment.newInstance()
                    GenresFragment.TAG -> GenresFragment.newInstance()
                    else -> SortedFilmsFragment.newInstance()
                }
            }

            replaceFragment(R.id.current_menu_container, selectedFragment, currentTag)

            title = currentTag

            return@OnNavigationItemSelectedListener true
        }

        main_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
    }

    private fun onBottomNavigationSelected(@IdRes id: Int) {
        val selectedTag = getTag(id)
        if (selectedTag == currentTag) {

            return
        }

        currentTag = selectedTag
    }

    private fun replaceFragment(@IdRes id: Int, f: Fragment, tag: String?) {
        supportFragmentManager.beginTransaction()
            .replace(id, f, tag)
            .addToBackStack(tag)
            .commit()
    }

    private fun getTag(@IdRes id: Int): String = when (id) {
        R.id.nav_films -> FilmsFragment.TAG
        R.id.nav_genres -> GenresFragment.TAG
        else -> SortedFilmsFragment.TAG
    }
}
