package com.android.movie.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.assignment.databinding.FragmentDetailBinding
import com.android.movie.screen.viewmodel.MovieViewModel
import com.android.movie.utils.MovieDetails
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var id: Int = 0
    private val viewModel: MovieViewModel by viewModel()

    companion object {
        private val TAG = "DetailFragment"
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = DetailFragmentArgs.fromBundle(it).id
            Log.i(TAG, "Values received detail: $id")
            viewModel.getMovieDetails(id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailFragment = this
        binding.movieViewModel = viewModel
        Log.i(TAG, "Values received detail: $id")
    }

    fun onButtonClick() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.movieDetail.value?.trailer))
        startActivity(intent)
        Toast.makeText(context, "Button Clicked Trailer", Toast.LENGTH_SHORT).show()
    }


}