package com.speechify.android.ui.test.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.speechify.android.ui.test.data.Book
import com.speechify.android.ui.test.repository.BookRepository
import kotlinx.coroutines.launch

class BookListViewModel(private val bookRepository: BookRepository) : ViewModel() {

    private var _books: MutableLiveData<List<Book>> = MutableLiveData()
    val books: LiveData<List<Book>> get() = _books

    init {
        fetchBooks()
    }

    private fun fetchBooks() {
        viewModelScope.launch {
            _books.value = bookRepository.getBooks()
        }
    }
}

class BookListViewModelFactory(private val bookRepository: BookRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookListViewModel(bookRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}