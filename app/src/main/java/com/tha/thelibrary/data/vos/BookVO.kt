package com.tha.thelibrary.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "book")
data class BookVO(

    @SerializedName("author")
    @ColumnInfo(name = "author")
    val author: String?,

    @SerializedName("book_image")
    @ColumnInfo(name = "book_image")
    val bookImage: String?,

    @SerializedName("book_image_width")
    @ColumnInfo(name = "book_image_width")
    val bookImageWidth: String?,

    @SerializedName("book_image_height")
    @ColumnInfo(name = "book_image_height")
    val bookImageHeight: String?,

    @SerializedName("contributor")
    @ColumnInfo(name = "contributor")
    val contributor: String?,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String?,

    @SerializedName("title")
    @PrimaryKey
    val title: String = ""

)
