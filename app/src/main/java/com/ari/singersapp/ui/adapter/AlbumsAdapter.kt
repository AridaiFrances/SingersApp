package com.ari.singersapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ari.singersapp.R
import com.ari.singersapp.databinding.AdapterAlbumViewBinding
import com.ari.singersapp.model.artist.top_albums.Album
import com.bumptech.glide.Glide

class AlbumsAdapter(
    private val albumsList: ArrayList<Album>
) : RecyclerView.Adapter<AlbumsAdapter.AlbumsAdapterViewHolder>() {


    override fun getItemCount(): Int = albumsList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlbumsContentAdapterViewHolder(
            AdapterAlbumViewBinding.inflate(layoutInflater, parent, false)
        )

    }

    override fun onBindViewHolder(holder: AlbumsAdapterViewHolder, position: Int) {
        when (holder) {
            is AlbumsContentAdapterViewHolder -> albumsList[position].let {
                holder.bind(
                    it
                )
            }
        }
    }

    open class AlbumsAdapterViewHolder(open val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root)


    inner class AlbumsContentAdapterViewHolder(override val binding: AdapterAlbumViewBinding) :
        AlbumsAdapterViewHolder(binding) {
        fun bind(album: Album) {
            binding.apply {
                textViewAlbumName.text =
                    album.name ?: textViewAlbumName.context.getString(R.string.no_info)
                album.image[3].text?.let {
                    Glide.with(imageViewAlbum.context)
                        .load(album.image[3].text)
                        .into(imageViewAlbum)
                } ?: kotlin.run {
                    imageViewAlbum.setImageDrawable(
                        ContextCompat.getDrawable(
                            imageViewAlbum.context,
                            R.drawable.default_image
                        )
                    )
                }

            }
        }
    }

}