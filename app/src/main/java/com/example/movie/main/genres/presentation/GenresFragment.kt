package com.example.movie.main.genres.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.databinding.FragmentGenresBinding
import com.example.movie.main.genres.data.model.Genre
import com.example.movie.main.genres.domain.GenresViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GenresFragment : BaseFragment() {

    companion object {
        const val TAG = "GenresFragment"
        fun newInstance() = GenresFragment()
    }

    lateinit var binding: FragmentGenresBinding
    private val viewModel: GenresViewModel by sharedViewModel()

    private val idList: MutableList<Int> = ArrayList()
    private val tabsTitleList: MutableList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_genres, container, false)
        initObservers()
        getData(savedInstanceState)
        return binding.root
    }

    private fun initObservers() {
        val genresObserver = Observer<List<Genre>> {genres ->
            genres.forEach { genre->
                idList.add(genre.id)
                tabsTitleList.add(genre.name)
            }
            addTabs(titles = tabsTitleList)
            binding.vpGenres.adapter = GenresPagerAdapter(childFragmentManager, idList)
            binding.vpGenres.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabGenres))
            binding.notifyChange()
        }

        viewModel.getGenresLD().observe(viewLifecycleOwner, genresObserver)
    }

    private fun addTabs(titles: List<String>) {
        titles.forEach {
            binding.tabGenres.addTab(binding.tabGenres.newTab().setText(it))
        }
    }

    private fun getData(savedInstanceState: Bundle?){
        savedInstanceState ?: viewModel.loadGenres()
    }


}
