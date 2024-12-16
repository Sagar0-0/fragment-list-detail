package com.speechify.android.ui.test.fragments

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.speechify.android.ui.test.R
import com.speechify.android.ui.test.databinding.FragmentBookDetailsBinding
import com.speechify.android.ui.test.databinding.FragmentBookListBinding
import com.speechify.android.ui.test.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookDetailsFragment : Fragment() {

    private var _binding: FragmentBookDetailsBinding? = null
    private val binding get() = _binding!!

    private val bookRepository = BookRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailsBinding.inflate(inflater, container, false)

        // Retrieve the arguments passed from the previous fragment
        val bookId = arguments?.getInt("id")
        val bookTitle = arguments?.getString("title")
        val bookAuthor = arguments?.getString("author")

        binding.txtTitle.text = bookTitle
        binding.txtAuthor.text = bookAuthor
        bookId?.let {
            loadBookImage(it)
        }

        return binding.root
    }

    private fun loadBookImage(bookId: Int) {
        lifecycleScope.launch {
            val bitmap: Bitmap = withContext(Dispatchers.IO) {
                bookRepository.getBookImageBitmap(bookId)
            }
            binding.ivBookCover.setImageBitmap(bitmap)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}