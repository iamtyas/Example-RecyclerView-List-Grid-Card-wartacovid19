package com.yastyas.beritacovid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yastyas.beritacovid_19.R
import com.yastyas.beritacovid_19.modeldata.Berita

class CardViewGalleryAdapter (val gridBerita: ArrayList<Berita>):
        RecyclerView.Adapter<CardViewGalleryAdapter.GridViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Berita)
    }

    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgFoto: ImageView = itemView.findViewById(R.id.iv_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview_gallery, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridBerita.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(gridBerita[position].img)
            .apply(RequestOptions().override(200,200))
            .into(holder.imgFoto)
    }

}