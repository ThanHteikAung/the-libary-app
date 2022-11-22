package com.tha.thelibrary.network.responses

import com.google.gson.annotations.SerializedName
import com.tha.thelibrary.data.vos.BookInfoVO

data class BooksListResponse(

    @SerializedName("results")
    val results : BookInfoVO?

)
