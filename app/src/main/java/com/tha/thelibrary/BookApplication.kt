package com.tha.thelibrary

import android.app.Application
import com.tha.thelibrary.data.models.BookModelImpl

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        BookModelImpl.initDatabase(applicationContext)
    }
}