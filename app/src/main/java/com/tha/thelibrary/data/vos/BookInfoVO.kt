package com.tha.thelibrary.data.vos

import com.google.gson.annotations.SerializedName

data class BookInfoVO(

    @SerializedName("lists")
    val lists : List<ListBookCategoryVO>?

)