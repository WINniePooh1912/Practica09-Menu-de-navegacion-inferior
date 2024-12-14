package com.example.p10bottomnav.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.p10bottomnav.R
import com.example.p10bottomnav.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val root: View = binding.root

        setImage(binding.imgBlusa, "Blusa", "Color rojo con texto 'Paradise'", R.drawable.blusa)
        setImage(binding.imgBroches, "Broches", "Accesorios dorados para el cabello", R.drawable.broches)
        setImage(binding.imgChamarra, "Chamarra", "Color blanco, con peluche por dentro", R.drawable.chamarra)
        setImage(binding.imgFalda, "Falda", "Corta color rojo con patrones en blanco", R.drawable.falda)
        setImage(binding.imgLentes, "Lentes", "De sol, color negro con marco dorado", R.drawable.lentes)
        setImage(binding.imgSueter, "Sueter", "Color blanco, oversize", R.drawable.sueter)

        return root
    }

    private fun setImage(imageView: ImageView, name: String, description: String, imageId: Int){
        imageView.setOnClickListener{
            val bundle = Bundle().apply {
                putString("name", name)
                putString("description", description)
                putInt("imageId", imageId)
            }

            findNavController().navigate(R.id.action_nav_gallery_to_detail, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}