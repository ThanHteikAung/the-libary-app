package com.tha.thelibrary.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.data.vos.ListBookCategoryVO

@Dao
interface ListBookCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListBookCategory(listBookCategory: List<ListBookCategoryVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleBook(book: BookVO?)

    @Query("SELECT * FROM listBookCategory")
    fun getListBookCategory(): LiveData<List<ListBookCategoryVO>>

    @Query("DELETE FROM listBookCategory")
    fun deleteAllListBookCategory()

}