package com.tha.thelibrary.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.tha.thelibrary.persistence.typeconverters.BookTypeConverter

@Entity(tableName = "listBookCategory")
@TypeConverters(
    BookTypeConverter::class
)
data class ListBookCategoryVO(

    @SerializedName("list_id")
    @PrimaryKey
    val listId: Int?,

    @SerializedName("list_name")
    @ColumnInfo(name = "list_name")
    val listName: String?,

    @SerializedName("list_name_encoded")
    @ColumnInfo(name = "list_name_encoded")
    val listNameEncoded: String?,

    @SerializedName("display_name")
    @ColumnInfo(name = "display_name")
    val displayName: String?,

    @SerializedName("books")
    @ColumnInfo(name = "books")
    val books: List<BookVO>?

)