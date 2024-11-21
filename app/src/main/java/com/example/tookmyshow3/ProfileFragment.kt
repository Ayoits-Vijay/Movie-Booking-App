package com.example.tookmyshow3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hide the search bar when this fragment is loaded
        val searchBar = requireActivity().findViewById<LinearLayout>(R.id.search_view)
        searchBar?.visibility = View.GONE

        // Find the "Your Orders" section by ID
        view.findViewById<LinearLayout>(R.id.orders_section)?.setOnClickListener {
            Log.d("ProfileFragment", "Your Orders clicked")

            // Fetch all booked tickets
            val tickets = TicketRepository.getAllTickets()

            if (tickets.isEmpty()) {
                // Show toast if no tickets booked
                Toast.makeText(context, "No tickets booked yet!", Toast.LENGTH_SHORT).show()
            } else {
                // Display tickets in a RecyclerView
                val recyclerView = RecyclerView(requireContext()).apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = TicketAdapter(tickets) // TicketAdapter to display tickets
                }

                // Show the RecyclerView in a dialog or a new fragment
                val dialog = TicketDialogFragment(recyclerView)
                dialog.show(parentFragmentManager, "TicketDialog")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Show the search bar again when leaving this fragment
        val searchBar = requireActivity().findViewById<LinearLayout>(R.id.search_view)
        searchBar?.visibility = View.VISIBLE
    }
}
