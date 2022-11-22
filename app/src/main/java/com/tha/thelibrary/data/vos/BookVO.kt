package com.tha.thelibrary.data.vos

import com.google.gson.annotations.SerializedName

data class BookVO(

    @SerializedName("author")
    val author: String?,

    @SerializedName("book_image")
    val bookImage: String?,

    @SerializedName("book_image_width")
    val bookImageWidth: String?,

    @SerializedName("book_image_height")
    val bookImageHeight: String?,

    @SerializedName("contributor")
    val contributor: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("title")
    val title: String?
)
