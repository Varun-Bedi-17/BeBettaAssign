package com.example.bebettaassignment.views.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bebettaassignment.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CoinsIntroductionBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_layout, container, false)

        // Find the dismiss button
        val btnDismiss = view.findViewById<Button>(R.id.btn_explore_now)
        // Set click listener to dismiss the bottom sheet
        btnDismiss.setOnClickListener {
            dismiss()
        }

        return view
    }
}