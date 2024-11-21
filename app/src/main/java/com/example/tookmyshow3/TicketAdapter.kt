package com.example.tookmyshow3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TicketAdapter(private val tickets: List<ticket>) : RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieName: TextView = itemView.findViewById(R.id.movie_name)
        val bookingDate: TextView = itemView.findViewById(R.id.booking_date)
        val seatNumber: TextView = itemView.findViewById(R.id.seat_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_item, parent, false)
        return TicketViewHolder(view)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = tickets[position]
        holder.movieName.text = ticket.movieName
        holder.bookingDate.text = ticket.bookingDate
        holder.seatNumber.text = ticket.seatNumber
    }

    override fun getItemCount(): Int = tickets.size
}
