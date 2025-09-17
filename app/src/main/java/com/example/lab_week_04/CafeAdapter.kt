package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(fragment: Fragment, private val contents: List<String>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = contents.size

    override fun createFragment(position: Int): Fragment {
        // Kirim langsung isi deskripsi (String) ke fragment
        return CafeDetailFragment.newInstance(contents[position])
    }
}
