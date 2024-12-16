package com.speechify.android.ui.test.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.speechify.android.ui.test.data.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.URL

class BookRepository {
    suspend fun getBooks(): List<Book> {
        delay(5000)
        return listOf(
            Book(id = 1, title = "The Great Gatsby", author = "F. Scott Fitzgerald"),
            Book(id = 2, title = "The Da Vinci Code", author = "Dan Brown"),
            Book(id = 3, title = "The Catcher in the Rye", author = "J. D. Salinger"),
            Book(id = 4, title = "The Hobbit", author = "J. R. R. Tolkien"),
            Book(id = 5, title = "The Hunger Games", author = "Suzanne Collins"),
            Book(id = 6, title = "The Kite Runner", author = "Khaled Hosseini"),
        )
    }

    private suspend fun loadBitmapFromURL(urlString: String): Bitmap {
        return withContext(Dispatchers.IO) {
            val url = URL(urlString)
            val connection = url.openConnection()
            connection.connect()
            val inputStream = connection.getInputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            bitmap
        }
    }

    suspend fun getBookImageBitmap(bookId: Int): Bitmap {
        delay(300)
        return loadBitmapFromURL("https://picsum.photos/400/400")
    }
}