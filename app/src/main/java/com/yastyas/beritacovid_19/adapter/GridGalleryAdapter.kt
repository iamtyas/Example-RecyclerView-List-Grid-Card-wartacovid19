package com.yastyas.beritacovid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yastyas.beritacovid_19.modeldata.Berita
import com.yastyas.beritacovid_19.R

class GridGalleryAdapter (val gridBerita: ArrayList<Berita>):
        RecyclerView.Adapter<GridGalleryAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Berita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_gallery, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(gridBerita[position].img)
            .apply(RequestOptions().override(200,200))
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return gridBerita.size
    }

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item)
    }
}