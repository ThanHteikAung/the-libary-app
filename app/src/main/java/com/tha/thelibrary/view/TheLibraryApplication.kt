package com.tha.thelibrary.view

import android.app.Application
import com.tha.thelibrary.data.models.BooksModelImpl

class TheLibraryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BooksModelImpl.initDatabase(applicationContext)
    }
}