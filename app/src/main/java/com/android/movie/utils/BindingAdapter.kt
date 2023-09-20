package com.android.movie.utils

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.assignment.R
import com.android.movie.screen.adapter.MovieListAdapter
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as MovieListAdapter
    adapter.submitList(data)
}

@BindingAdapter("networkImage")
fun bindMovieItem(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri) {
            placeholder(R.drawable.ic_loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}


@BindingAdapter("movieStatus")
fun bindStatus(imageView: ImageView, status: Status) {
    when(status) {
        Status.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_loading_animation)
        }
        Status.SUCCESS -> {
            imageView.visibility = View.GONE
        }
        Status.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}