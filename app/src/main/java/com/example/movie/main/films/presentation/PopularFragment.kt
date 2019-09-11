package com.example.movie.main.films.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.BR
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.base.RecyclerBindingAdapter
import com.example.movie.databinding.FragmentPopularBinding
import com.example.movie.main.films.data.model.PopularMovie
import com.example.movie.main.films.domain.PopularViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularFragment : BaseFragment() {

    companion object{
        const val TAG = "PopularFragment"

        fun newInstance() = PopularFragment()
    }

    lateinit var binding: FragmentPopularBinding
    private val viewModel: PopularViewModel by viewModel()
    private var adapter: RecyclerBindingAdapter<PopularMovie>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = RecyclerBindingAdapter(
            holderLayout = R.layout.item_popular,
            variableId = BR.popular,
            context = context!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
        binding.rvPopulars.adapter = adapter
        binding.rvPopulars.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        getData(savedInstanceState = savedInstanceState)
        return binding.root
    }

    private fun getData(savedInstanceState: Bundle?){
        savedInstanceState ?: viewModel.loadPopulars()
    }


}
