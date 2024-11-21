package com.example.tookmyshow3

object TicketRepository {
    private val bookedTickets = mutableListOf<ticket>()

    fun addTicket(ticket: ticket) {
        bookedTickets.add(ticket)
    }

    fun getAllTickets(): List<ticket> {
        return bookedTickets
    }
}
