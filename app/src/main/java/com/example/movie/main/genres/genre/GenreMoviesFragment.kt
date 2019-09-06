package com.example.movie.main.genres.genre


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.BR
import com.example.movie.R
import com.example.movie.base.BaseFragment
import com.example.movie.base.RecyclerBindingAdapter
import com.example.movie.databinding.FragmentGenreMoviesBinding
import com.example.movie.main.genres.data.model.Movie
import com.example.movie.main.genres.domain.GenreMoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val GENRE_ID = "genre_id"
private const val DEFAULT_ID = -1

class GenreMoviesFragment : BaseFragment() {

    companion object{
        const val TAG = "GenreMoviesFragment"

        fun newInstance(id: Int) = GenreMoviesFragment().apply {
            arguments = Bundle().apply {
                putInt(GENRE_ID, id)
            }
        }
    }

    lateinit var binding: FragmentGenreMoviesBinding
    private val viewModel: GenreMoviesViewModel by viewModel()
    private var adapter: RecyclerBindingAdapter<Movie>? = null

    private var genreId: Int = DEFAULT_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            genreId = it.getInt(GENRE_ID, DEFAULT_ID)
        }
        adapter = RecyclerBindingAdapter(
            holderLayout = R.layout.item_genre_movie,
            variableId = BR.movie,
            context = context!!
        )
        viewModel.getGenreMovies(genreId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_genre_movies, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvMovies.adapter = adapter
        binding.rvMovies.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.viewModel = viewModel

        return binding.root
    }


}
