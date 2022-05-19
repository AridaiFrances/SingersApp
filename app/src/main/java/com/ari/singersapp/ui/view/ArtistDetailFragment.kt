package com.ari.singersapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ari.singersapp.databinding.ArtistDetailFragmentBinding

class ArtistDetailFragment : Fragment() {

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
