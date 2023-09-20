package com.android.movie.screen.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.databinding.MovieItemBinding
import com.android.movie.screen.HomeFragmentDirections
import com.android.movie.utils.Movie

class MovieListAdapter(private val navController: NavController): ListAdapter<Movie, MovieListAdapter.MovieListViewHolder>(DiffCallback) {

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
        }
    }

    inner class MovieListViewHolder(val binding: MovieItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding: MovieItemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context))
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        val id = item.id
        holder.binding.cardViewMovie.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
            navController.navigate(action)
        }
    }

}