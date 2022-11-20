package com.tha.thelibrary.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tha.thelibrary.data.vos.BooksVO

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(books: List<BooksVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleBook(book: BooksVO?)

    @Query("SELECT * FROM books")
    fun getAllBooks(): LiveData<List<BooksVO>>

    @Query("SELECT * FROM books WHERE title = :title ")
    fun getBookByTitle(title: String): BooksVO?

    @Query("DELETE FROM books")
    fun deleteAllBooks()
}