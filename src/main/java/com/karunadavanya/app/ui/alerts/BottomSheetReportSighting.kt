package com.karunadavanya.app.ui.alerts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.karunadavanya.app.databinding.DialogReportSightingBinding

class BottomSheetReportSighting(
    private val onSubmit: (String, String, String) -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: DialogReportSightingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogReportSightingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup dropdown
        val animals = arrayOf("Elephant", "Leopard", "Tiger", "Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, animals)
        binding.spinnerAnimalType.adapter = adapter

        binding.btnSubmit.setOnClickListener {
            val animalType = binding.spinnerAnimalType.selectedItem.toString()
            val location = binding.etLocation.text.toString().trim()
            val notes = binding.etNotes.text.toString().trim()

            if (location.isNotEmpty()) {
                onSubmit(animalType, location, notes)
                dismiss()
            } else {
                binding.etLocation.error = "Location is required"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
