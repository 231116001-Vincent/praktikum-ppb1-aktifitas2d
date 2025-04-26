package com.vharya.aktifitas2d

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val matkul = arrayListOf(
        "Kalkulus", "Jaringan Komputer", "Pemrograman Mobile",
        "Sistem Operasi", "Basis Data", "Etika Komputer",
        "Information Retrieval", "Pengolahan Citra Digital",
        "Artificial Inteligence", "Pemrograman Web lanjut"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = ListAdapter(this, matkul)
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this,
                "${matkul[position]} is pressed!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}