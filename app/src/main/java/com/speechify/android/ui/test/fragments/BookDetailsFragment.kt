package com.speechify.android.ui.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.speechify.android.ui.test.R
import com.speechify.android.ui.test.databinding.FragmentBookDetailsBinding
import com.speechify.android.ui.test.databinding.FragmentBookListBinding

class BookDetailsFragment : Fragment() {

    private var _binding: FragmentBookDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailsBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

}