package com.ari.singersapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.ari.singersapp.R
import com.ari.singersapp.databinding.ArtistDetailFragmentBinding
import com.ari.singersapp.model.artist.artist_info.ArtistInfoResponse
import com.ari.singersapp.model.artist.top_albums.ArtistTopAlbumsResponse
import com.ari.singersapp.ui.adapter.AlbumsAdapter
import com.ari.singersapp.ui.viewmodel.ArtistDetailViewModel
import com.ari.singersapp.utils.Status
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistDetailFragment : Fragment() {


    private val viewModel: ArtistDetailViewModel by viewModel()

    private lateinit var adapter: AlbumsAdapter

    private val args: ArtistDetailFragmentArgs by navArgs()

    private lateinit var binding: ArtistDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArtistDetailFragmentBinding.inflate(layoutInflater)

        initFragment()

        return binding.root
    }

    private fun initFragment() {
        val receptionString = args.artistMbid

        fetchArtistData(receptionString)
        setupObservers()
    }

    private fun fetchArtistData(artistMbid: String) {
        viewModel.fetchArtistInfo(artistMbid)
        viewModel.fetchArtistAlbums(artistMbid)
    }

    private fun setupObservers() {
        viewModel.artistInfo.observe(viewLifecycleOwner) {
            binding.apply {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { artistInfoResponse ->
                            bindArtistInfoViews(artistInfoResponse)
                        }
                        progressBar.visibility = GONE
                        viewHelper.visibility = GONE
                    }
                    Status.LOADING -> {
                        progressBar.visibility = VISIBLE
                        viewHelper.visibility = VISIBLE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        progressBar.visibility = GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        viewModel.artistAlbums.observe(viewLifecycleOwner) {
            binding.apply {
                when (it.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = GONE
                        it.data?.let { artistAlbums ->
                            initArtistTopAlbumsRecyclerView(artistAlbums)
                        }
                        viewHelper.visibility = GONE
                    }
                    Status.LOADING -> {
                        progressBar.visibility = VISIBLE
                        viewHelper.visibility = VISIBLE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        progressBar.visibility = GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

    private fun bindArtistInfoViews(artistResponse: ArtistInfoResponse) {
        binding.apply {

            artistResponse.artist?.let {

                it.image[3].text?.let {
                    Glide.with(imageViewArtist.context)
                        .load(it)
                        .into(imageViewArtist)
                } ?: kotlin.run {
                    imageViewArtist.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.default_image
                        )
                    )
                }

                textViewName.text = it.name ?: activity?.getString(R.string.no_info)
                textViewSummary.text = it.bio?.summary ?: activity?.getString(R.string.no_info)
            } ?: kotlin.run {
                showErrorLayout()
            }


        }
    }

    private fun initArtistTopAlbumsRecyclerView(artists: ArtistTopAlbumsResponse?) {

        artists?.topalbums?.album?.let {
            adapter = AlbumsAdapter(it)
            binding.apply {
                recyclerViewAlbumDetail.layoutManager =
                    GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                recyclerViewAlbumDetail.setHasFixedSize(true)


                recyclerViewAlbumDetail.adapter = adapter
            }
        } ?: kotlin.run {
            showErrorLayout()
        }

    }

    private fun showErrorLayout() {
        binding.FrameLayoutErrorHelper.visibility = VISIBLE
        binding.buttonOpenUrl.visibility = GONE
    }
}