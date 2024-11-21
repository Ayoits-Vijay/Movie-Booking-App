package com.example.tookmyshow3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class MovieDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)

        // Retrieve data from arguments
        val title = arguments?.getString("title")
        val imageResId = arguments?.getInt("imageResId")
        val description = arguments?.getString("description")

        // Bind data to views
        view.findViewById<ImageView>(R.id.imageMovieDetails).setImageResource(imageResId!!)
        view.findViewById<TextView>(R.id.textMovieTitleDetails).text = title
        view.findViewById<TextView>(R.id.textMovieDescription).text = description

        // Handle "BOOK TICKET" button click
        val bookTicketButton = view.findViewById<Button>(R.id.bookTicketButton)
        bookTicketButton.setOnClickListener {
            Toast.makeText(requireContext(), "Ticket booked for $title!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
