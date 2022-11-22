package com.tha.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tha.thelibrary.data.vos.BookVO

class BookTypeConverter {

    @TypeConverter
    fun toString(book:List<BookVO>?): String{
        return Gson().toJson(book)
    }

    @TypeConverter
    fun toBookVO(bookListJsonStr: String): List<BookVO>?{
        val bookVOType = object : TypeToken<List<BookVO>?>(){}.type
        return Gson().fromJson(bookListJsonStr,bookVOType)
    }

}