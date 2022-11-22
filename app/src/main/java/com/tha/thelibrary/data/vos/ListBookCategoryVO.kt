package com.tha.thelibrary.data.vos

import com.google.gson.annotations.SerializedName

data class ListBookCategoryVO(

    @SerializedName("list_id")
    val listId : Int?,

    @SerializedName("list_name")
    val listName : String?,

    @SerializedName("list_name_encoded")
    val listNameEncoded : String?,

    @SerializedName("display_name")
    val displayName : String?,

    @SerializedName("books")
    val books : List<BookVO>?

)