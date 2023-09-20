package com.android.movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.assignment.R
import com.android.assignment.databinding.FragmentHomeBinding
import com.android.movie.screen.adapter.MovieListAdapter
import com.android.movie.screen.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = movieViewModel
        movieViewModel.fetchSource()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewHome.apply {
            adapter = MovieListAdapter(findNavController())
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}