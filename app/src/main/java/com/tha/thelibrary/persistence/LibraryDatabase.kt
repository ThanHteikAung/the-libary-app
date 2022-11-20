package com.tha.thelibrary.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.persistence.daos.BooksDao

@Database(entities = [BooksVO::class], version = 1, exportSchema = false)
abstract class LibraryDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "THE_LIBRARY_DB"
        var dbInstance: LibraryDatabase? = null
        fun getDBInstance(context: Context): LibraryDatabase? {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, LibraryDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance
        }
    }

    abstract fun booksDao(): BooksDao
}
