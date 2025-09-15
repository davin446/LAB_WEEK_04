package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ambil semua item kopi
        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte)
        )

        // setiap kopi punya action ke DetailFragment
        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt(COFFEE_ID, coffee.id)  // kirim id kopi
                }
                Navigation.findNavController(view)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
