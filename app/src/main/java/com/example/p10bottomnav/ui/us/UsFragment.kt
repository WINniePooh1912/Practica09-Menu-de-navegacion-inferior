package com.example.p10bottomnav.ui.us

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.example.p10bottomnav.R
import com.example.p10bottomnav.databinding.FragmentUsBinding

class UsFragment : Fragment() {

    private var _binding: FragmentUsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUsBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val web_page = binding.btnWebPage
        web_page.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/indiraynuba?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw=="))
            startActivity(intent)
        }

        val mcVideo = MediaController(requireContext())
        mcVideo.setAnchorView(binding.vvRep)
        binding.vvRep.setMediaController(mcVideo)
        val ruta = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.liverpool)
        binding.vvRep.setVideoURI(ruta)
        binding.vvRep.requestFocus()
        binding.vvRep.start()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}