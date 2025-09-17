package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        // Data deskripsi dari strings.xml
        val contents = listOf(
            getString(R.string.starbucks_desc),
            getString(R.string.janjijiwa_desc),
            getString(R.string.kopikenangan_desc)
        )

        // Pasang adapter baru (punya kamu)
        val adapter = CafeAdapter(this, contents)
        viewPager.adapter = adapter

        // Data judul tab dari strings.xml
        val titles = listOf(
            getString(R.string.starbucks_title),
            getString(R.string.janjijiwa_title),
            getString(R.string.kopikenangan_title)
        )

        // Hubungkan tab dengan ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}
