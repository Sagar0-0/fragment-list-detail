package com.speechify.android.ui.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.speechify.android.ui.test.R
import com.speechify.android.ui.test.databinding.FragmentBookListBinding
import com.speechify.android.ui.test.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookListFragment : Fragment() {

    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }
}