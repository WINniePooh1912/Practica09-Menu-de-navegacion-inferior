package com.example.p10bottomnav.ui.credit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.p10bottomnav.R
import com.example.p10bottomnav.databinding.FragmentCreditBinding


class CreditFragment : Fragment() {
    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    private lateinit var date: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)

        binding.calendarView.setOnDateChangeListener { _, year, month, day ->
            date = "$day/${month + 1}/$year"
        }

        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString()
            val last_name = binding.edtLastName.text.toString()

            if(name.isNotBlank() && last_name.isNotBlank() && ::date.isInitialized) {
                Toast.makeText(
                    requireContext(),
                    "Nombre(s): $name \n Apellido(s): $last_name \n Fecha: $date", Toast.LENGTH_LONG).show()
                binding.edtName.text = null
                binding.edtLastName.text = null

                binding.edtName.requestFocus()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Llene los campos para agendar una cita", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}