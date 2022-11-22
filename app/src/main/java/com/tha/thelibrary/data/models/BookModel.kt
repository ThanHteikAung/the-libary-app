package com.tha.thelibrary.data.models

import com.tha.thelibrary.data.vos.ListBookCategoryVO

interface BookModel {
    fun getOverview(
        onSuccess: (List<ListBookCategoryVO>?) -> Unit,
        onFailure: (String) -> Unit
    )
}