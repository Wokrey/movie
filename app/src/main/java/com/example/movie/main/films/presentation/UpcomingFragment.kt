package com.example.movie.main.films.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movie.BR
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.base.RecyclerBindingAdapter
import com.example.movie.databinding.FragmentUpcomingBinding
import com.example.movie.main.films.data.model.UpcomingMovie
import com.example.movie.main.films.domain.UpcomingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class UpcomingFragment : BaseFragment() {

    companion object {
        const val TAG = "UpcomingFragment"

        fun newInstance() = UpcomingFragment()
    }

    lateinit var binding: FragmentUpcomingBinding
    lateinit var adapter: RecyclerBindingAdapter<UpcomingMovie>

    private val viewModel: UpcomingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = RecyclerBindingAdapter(
            holderLayout = R.layout.item_upcoming,
            variableId = BR.upcoming,
            context = context!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_upcoming, container, false)
        binding.rvUpcoming.adapter = adapter
        binding.rvUpcoming.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        getData(savedInstanceState)
        return binding.root
    }

    private fun getData(savedInstanceState: Bundle?) {
        savedInstanceState ?: viewModel.loadUpcomingMovies()
    }


}
