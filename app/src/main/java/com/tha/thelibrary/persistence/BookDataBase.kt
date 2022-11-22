package com.tha.thelibrary.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tha.thelibrary.data.vos.BookVO
import com.tha.thelibrary.data.vos.ListBookCategoryVO
import com.tha.thelibrary.persistence.daos.ListBookCategoryDao

@Database(entities = [ListBookCategoryVO::class, BookVO::class], version = 1, exportSchema = false)
abstract class BookDataBase : RoomDatabase() {

    companion object {
        const val DB_NAME = "THE BOOK DB"

        var dbInstance: BookDataBase? = null
        fun getDBInstance(context: Context): BookDataBase? {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, BookDataBase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance
        }
    }

    abstract fun listBookCategoryDao(): ListBookCategoryDao

}