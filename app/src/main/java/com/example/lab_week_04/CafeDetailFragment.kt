package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CafeDetailFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "position"

        // Gunakan factory method untuk membuat fragment dengan posisi
        fun newInstance(position: Int): CafeDetailFragment {
            val fragment = CafeDetailFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ambil posisi dari arguments
        arguments?.let {
            position = it.getInt(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cafe_detail, container, false)
        val textView = view.findViewById<TextView>(R.id.tv_cafe_desc)

        val descRes = when (position) {
            0 -> R.string.starbucks_desc
            1 -> R.string.janjijiwa_desc
            2 -> R.string.kopikenangan_desc
            else -> R.string.starbucks_desc
        }

        textView.text = getString(descRes)
        return view
    }
}