package com.ari.singersapp.ui.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ari.singersapp.R
import com.ari.singersapp.databinding.ArtistCollectionListFragmentBinding
import com.ari.singersapp.model.artist.Artist
import com.ari.singersapp.model.artist.ArtistCollectionResponse
import com.ari.singersapp.model.artist.search_by_name.ArtistByNameResponse
import com.ari.singersapp.ui.adapter.ArtistsAdapter
import com.ari.singersapp.ui.component.CustomSearchView
import com.ari.singersapp.ui.viewmodel.ArtistCollectionListViewModel
import com.ari.singersapp.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistCollectionListFragment : Fragment() {

    private val viewModel: ArtistCollectionListViewModel by viewModel()

    private lateinit var adapter: ArtistsAdapter

    private lateinit var binding: ArtistCollectionListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArtistCollectionListFragmentBinding.inflate(layoutInflater)

        initFragment()

        return binding.root
    }


    private fun initFragment() {
        initArtistRecyclerView()
        initCustomSearchView()
        setupObserver()
    }

    /**
     * Start to observe LiveData to refresh UI
     */
    private fun setupObserver() {
        viewModel.artists.observe(viewLifecycleOwner) {
            binding.apply {
                when (it.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        it.data?.let { artists ->
                            when (artists) {
                                is ArtistCollectionResponse -> reloadRecyclerViewContent(artists.artistsCollection.artistList)
                                is ArtistByNameResponse -> reloadRecyclerViewContent(artists.results.artistmatches.artist)
                            }
                        }
                        recyclerView.visibility = View.VISIBLE
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        //Handle Error
                        progressBar.visibility = View.GONE
                        showErrorLayout()
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

    /**
     * Init recyclerView
     */
    private fun initArtistRecyclerView() {
        adapter = ArtistsAdapter(arrayListOf(), object : ArtistsAdapter.OnArtistClickListener {
            override fun onClick(artistMbid: String?) {
                navigateToArtistDetail(artistMbid)
            }

        })
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

    }

    /**
     * Refresh data and adapter
     */
    private fun reloadRecyclerViewContent(artistsList: ArrayList<Artist>) {
        adapter.addData(artistsList)
        adapter.notifyDataSetChanged()
    }

    /**
     * Init custom searchView
     */
    private fun initCustomSearchView() {
        binding.customViewSearch.setOnSearchListener(object : CustomSearchView.OnSearchListener {
            override fun onSearchResults(textData: String) {
                fetchArtistByText(textData)
                hideKeyboard()
            }

            override fun onDeleteText() {
                fetchArtists()
                hideKeyboard()
            }

        })
    }

    /**
     * Call to fetch artists again
     */
    private fun fetchArtists() {
        viewModel.fetchArtists()
    }

    /**
     * Call to fetch filtered artists
     */
    private fun fetchArtistByText(artistName: String) {
        viewModel.fetchArtistByName(artistName)
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }


    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    /**
     * Manage navigation component
     */
    private fun navigateToArtistDetail(artistMbid: String?) {
        artistMbid?.let { mbid ->
            val direction =
                ArtistCollectionListFragmentDirections.actionArtistCollectionListFragmentToArtistDetailFragment2(
                    mbid
                )
            findNavController().navigate(direction)
        } ?: kotlin.run {
            Toast.makeText(
                requireContext(),
                requireContext().getString(R.string.error_null_mbid),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun showErrorLayout() {
        binding.FrameLayoutErrorHelper.visibility = View.VISIBLE
    }
}