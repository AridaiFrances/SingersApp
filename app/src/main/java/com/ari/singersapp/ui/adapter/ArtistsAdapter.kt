package com.ari.singersapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ari.singersapp.R
import com.ari.singersapp.databinding.AdapterArtistViewBinding
import com.ari.singersapp.model.artist.Artist
import com.bumptech.glide.Glide

class ArtistsAdapter(
    private val artistList: ArrayList<Artist>,
    private val onArtistClickListener: OnArtistClickListener?,
) : RecyclerView.Adapter<ArtistsAdapter.SingersAdapterViewHolder>() {

    /**
     * Interface to implement custom click
     */
    interface OnArtistClickListener {
        fun onClick(artistMbid: String?)
    }

    fun addData(newContentList: ArrayList<Artist>) {
        artistList.clear()
        artistList.addAll(newContentList)
    }

    override fun getItemCount(): Int = artistList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingersAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SingersAdapterDataViewHolder(
            AdapterArtistViewBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SingersAdapterViewHolder, position: Int) {
        when (holder) {
            is SingersAdapterDataViewHolder -> artistList[position].let {
                holder.bind(
                    it
                )
            }
        }
    }

    open class SingersAdapterViewHolder(open val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class SingersAdapterDataViewHolder(override val binding: AdapterArtistViewBinding) :
        SingersAdapterViewHolder(binding) {
        fun bind(artist: Artist) {
            binding.apply {
                textViewName.text = artist.name ?: textViewName.context.getString(R.string.no_info)
                textViewPlayCount.text = textViewName.context.getString(
                    R.string.number_of_reproductions,
                    artist.playcount ?: "0"
                )
                artist.image[3].text?.let {
                    Glide.with(imageViewAvatar.context)
                        .load(artist.image[3].text)
                        .into(imageViewAvatar)
                } ?: kotlin.run {
                    imageViewAvatar.setImageDrawable(
                        ContextCompat.getDrawable(
                            imageViewAvatar.context,
                            R.drawable.default_image
                        )
                    )
                }
                clContainer.setOnClickListener { onArtistClickListener?.onClick(artist.mbid) }
            }
        }
    }
}