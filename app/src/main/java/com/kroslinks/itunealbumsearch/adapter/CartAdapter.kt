package com.kroslinks.itunealbumsearch.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroslinks.itunealbumsearch.R
import com.kroslinks.itunealbumsearch.model.Result
import com.kroslinks.itunealbumsearch.utility.Util

class CartAdapter(val context: Context, private val list: List<Result>) : RecyclerView.Adapter<AlbumViewHolder>() {
    var albumFilter: List<Result>? = null
    var filterList: List<Result>? = null

    init{
        albumFilter=list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return albumFilter!!.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val movie: Result = albumFilter!![position]
        holder.bind(context,movie)
    }



}


class AlbumViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var mTitleView: TextView? = null
    private var trackName: TextView? = null
    private var collectionName: TextView? = null
    private var collectionPrice: TextView? = null
    private var releaseDate: TextView? = null
    private var imageView:ImageView?=null
    private var parentLayout: LinearLayout?=null
    init {
        mTitleView = itemView.findViewById(R.id.list_artistName)
        trackName = itemView.findViewById(R.id.list_trackName)
        collectionName = itemView.findViewById(R.id.list_collection_name)
        collectionPrice = itemView.findViewById(R.id.list_collection_price)
        releaseDate=itemView.findViewById(R.id.list_release_date)
        imageView=itemView.findViewById(R.id.image_view)
        parentLayout=itemView.findViewById(R.id.parent_layout)


    }

    fun bind(
        context: Context,
        albumData: Result

    ) {
        mTitleView?.text = albumData.artistName
        trackName?.text = albumData.trackName
        collectionName?.text = albumData.collectionName
        collectionPrice?.text = albumData.currency+" "+albumData.collectionPrice.toString()
        releaseDate?.text = Util.splitDate(albumData.releaseDate)
        Glide.with(context).load(albumData.artworkUrl100).into(imageView!!)


    }


}