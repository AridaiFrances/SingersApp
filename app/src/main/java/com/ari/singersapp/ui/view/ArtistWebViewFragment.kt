package com.ari.singersapp.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ari.singersapp.databinding.FragmentArtistWebViewBinding

class ArtistWebViewFragment : Fragment() {

    private lateinit var binding: FragmentArtistWebViewBinding

    private val args: ArtistWebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArtistWebViewBinding.inflate(layoutInflater)
        initFragment()
        return binding.root
    }

    private fun initFragment() {
        val receptionString = args.artistUrl
        initWebview(receptionString)
    }

    /**
     * Init and load webView
     */
    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebview(url: String) {
        binding.apply {
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            webView.loadUrl(url)
        }

    }
}