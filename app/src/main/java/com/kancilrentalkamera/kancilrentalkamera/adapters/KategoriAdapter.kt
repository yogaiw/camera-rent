package com.kancilrentalkamera.kancilrentalkamera.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kancilrentalkamera.kancilrentalkamera.R
import com.kancilrentalkamera.kancilrentalkamera.data.DataKategori
import kotlinx.android.synthetic.main.activity_main.view.*

class KategoriAdapter(private val listMyData: ArrayList<DataKategori>) : RecyclerView.Adapter<KategoriAdapter.KategoriHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kategori, parent, false)
        return KategoriHolder(view)
    }

    override fun onBindViewHolder(holder: KategoriHolder, position: Int) {
        holder.bind(listMyData[position])
    }

    override fun getItemCount(): Int = listMyData.size

    inner class KategoriHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dataKategori: DataKategori) {
            with(itemView){
                tv_kategori.text = dataKategori.kategori
            }
        }
    }
}