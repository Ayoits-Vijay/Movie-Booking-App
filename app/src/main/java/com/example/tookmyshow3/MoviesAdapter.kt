package com.example.tookmyshow3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(
    private var movies: List<movie>, // Use a mutable list if dynamic updates are needed
    private val onItemClick: (movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie, onItemClick)
    }

    override fun getItemCount(): Int = movies.size

    /**
     * Updates the list of movies in the adapter.
     */
    fun updateData(newMovies: List<movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.movie_image)
        private val titleView: TextView = itemView.findViewById(R.id.movie_title)

        /**
         * Binds the movie data to the views.
         */
        fun bind(movie: movie, onItemClick: (movie) -> Unit) {
            imageView.setImageResource(movie.imageResId)
            titleView.text = movie.title
            itemView.setOnClickListener { onItemClick(movie) }
        }
    }
}
