package com.kancilrentalkamera.kancilrentalkamera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.kancilrentalkamera.kancilrentalkamera.adapters.KategoriAdapter
import com.kancilrentalkamera.kancilrentalkamera.data.DataKategori
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<DataKategori>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        viewManager = LinearLayoutManager(this)
        viewAdapter = KategoriAdapter(DataKategori)

        rv_kategori.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    fun getKatagori(): ArrayList<DataKategori> {
        val namaKategori = resources.getStringArray(R.array.kategori)
        val listKategori = ArrayList<DataKategori>()

        for (position in namaKategori.indices) {
            val kategori = DataKategori(namaKategori[position])
            listKategori.add(kategori)
        }
        return listKategori
    }
}