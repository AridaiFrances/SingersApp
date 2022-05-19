package com.ari.singersapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ari.singersapp.databinding.FragmentArtistWebViewBinding

class ArtistWebViewFragment : Fragment() {

    private lateinit var binding: FragmentArtistWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistWebViewBinding.inflate(layoutInflater)
        initFragment()
        return binding.root
    }

    private fun initFragment() {}
}