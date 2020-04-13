package com.yastyas.beritacovid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yastyas.beritacovid_19.R
import com.yastyas.beritacovid_19.modeldata.Berita

class CardViewBeritaAdapter (val listBerita: ArrayList<Berita>) :
    RecyclerView.Adapter<CardViewBeritaAdapter.ListCardViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Berita)
    }

    inner class ListCardViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJudul: TextView = itemView.findViewById(R.id.tv_judul)
        var tvRingkasan: TextView = itemView.findViewById(R.id.tv_ringkasan)
        var tvSrc: TextView = itemView.findViewById(R.id.tv_src)
        var imgFoto: ImageView = itemView.findViewById(R.id.iv_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCardViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview_berita, parent, false)
        return ListCardViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listBerita.size
    }

    override fun onBindViewHolder(holder: ListCardViewHolder, position: Int) {
        val berita = listBerita[position]
        Glide.with(holder.itemView.context)
            .load(berita.img)
            .apply(RequestOptions().override(200,100))
            .into(holder.imgFoto)
        holder.tvJudul.text = berita.judul
        holder.tvRingkasan.text = berita.ringkasan
        holder.tvSrc.text = berita.src
    }

}