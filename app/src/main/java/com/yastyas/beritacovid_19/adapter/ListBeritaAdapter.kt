package com.yastyas.beritacovid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yastyas.beritacovid_19.modeldata.Berita
import com.yastyas.beritacovid_19.R

class ListBeritaAdapter(val listBerita: ArrayList<Berita>) :
    RecyclerView.Adapter<ListBeritaAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_berita, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val berita = listBerita[position]
        Glide.with(holder.itemView.context)
            .load(berita.img)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvJudul.text = berita.judul
        holder.tvRingkasan.text = berita.ringkasan
        holder.tvSrc.text = berita.src
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listBerita[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJudul: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRingkasan: TextView = itemView.findViewById(R.id.tv_item_detail)
        var tvSrc: TextView = itemView.findViewById(R.id.tv_item_src)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Berita)
    }
}