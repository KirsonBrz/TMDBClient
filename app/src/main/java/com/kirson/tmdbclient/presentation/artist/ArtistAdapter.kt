package com.kirson.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kirson.tmdbclient.R
import com.kirson.tmdbclient.data.model.artist.Artist
import com.kirson.tmdbclient.databinding.ListItemBinding

class ArtistAdapter() : RecyclerView.Adapter<MyViewHolderArtist>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderArtist {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolderArtist(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolderArtist, position: Int) {

        holder.bind(artistList[position])


    }

    override fun getItemCount(): Int {
        return artistList.size
    }


}

class MyViewHolderArtist(
    val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)

    }

}