package com.ari.singersapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ari.singersapp.databinding.ArtistDetailFragmentBinding
import com.ari.singersapp.ui.viewmodel.ArtistDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistDetailFragment : Fragment() {

    private val viewModel: ArtistDetailViewModel by viewModel()

    private lateinit var binding: ArtistDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArtistDetailFragmentBinding.inflate(layoutInflater)

        initFragment()

        return binding.root
    }

    private fun initFragment() {}

}
