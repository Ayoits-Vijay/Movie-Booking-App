package com.example.tookmyshow3

import android.app.Dialog
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class TicketDialogFragment(private val recyclerView: RecyclerView) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Your Booked Tickets")
            .setView(recyclerView)
            .setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
        return builder.create()
    }
}

