package com.ari.singersapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ari.singersapp.databinding.ArtistCollectionListFragmentBinding
import com.ari.singersapp.ui.viewmodel.ArtistCollectionListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistCollectionListFragment : Fragment() {

    private lateinit var binding: ArtistCollectionListFragmentBinding

    private val viewModel: ArtistCollectionListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArtistCollectionListFragmentBinding.inflate(layoutInflater)

        initFragment()

        return binding.root
    }


    private fun initFragment() {}

}