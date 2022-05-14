package com.itgenius.firstandroidapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import com.itgenius.firstandroidapp.R

class MainActivityOld : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setContentView(R.layout.constrain2_layout)

        // ค้นหาตัวแปรจากฝั่ง xml แล้วเก็บลงตัวแปร
        // var tvHello = findViewById<TextView>(R.id.tvHello)
        // tvHello.text = "Welcome to my android app"

        val btnMenu1 = findViewById<Button>(R.id.btnMenu1)
        val btnMenu2 = findViewById<Button>(R.id.btnMenu2)
        val btnMenu3 = findViewById<Button>(R.id.btnMenu3)

        btnMenu1.setOnClickListener {
            findNavController(R.id.nav_host).popBackStack(R.id.firstFragment, false)
        }

        btnMenu2.setOnClickListener {
            findNavController(R.id.nav_host).navigate(R.id.secondFragment)
        }

        btnMenu3.setOnClickListener {
            findNavController(R.id.nav_host).navigate(R.id.thirdFragment)
        }

    }
}