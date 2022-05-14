package com.itgenius.firstandroidapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.itgenius.firstandroidapp.R

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // การ findView
        val btnNext = view.findViewById<Button>(R.id.btnNext)
        // การ setOnClickListener
        btnNext.setOnClickListener {
            // Toast.makeText(activity, "You clicked btnNext at First Fragment", Toast.LENGTH_SHORT).show()

            // การเปลี่ยน Fragment secondFragment
            findNavController().navigate(R.id.secondFragment)
        }
    }
}