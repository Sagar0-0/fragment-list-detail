package com.speechify.android.ui.test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.speechify.android.ui.test.R
import com.speechify.android.ui.test.data.Book
import com.speechify.android.ui.test.databinding.FragmentBookListBinding
import com.speechify.android.ui.test.repository.BookRepository

class BookListFragment : Fragment(), OnBookClickListener {

    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookAdapter: BookAdapter

    private val bookRepository = BookRepository()
    private val viewModel: BookListViewModel by activityViewModels {
        BookListViewModelFactory(
            bookRepository
        )
    }

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        // Set up RecyclerView
        bookAdapter = BookAdapter(this)
        binding.rvBookList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBookList.adapter = bookAdapter

        fetchBooks()
    }

    private fun fetchBooks() {
        viewModel.books.observe(viewLifecycleOwner) { books ->
            bookAdapter.submitList(books)
            binding.progressBar.visibility = if (books.isEmpty()) VISIBLE else GONE
        }
    }

    override fun onBookClick(book: Book) {
        navController.navigate(
            R.id.action_bookListFragment_to_bookDetailsFragment,
            Bundle().apply {
                putInt("id", book.id)
                putString("title", book.title)
                putString("author", book.author)
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}