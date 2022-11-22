package com.tha.thelibrary.network.dataagents

import com.tha.thelibrary.data.vos.ListBookCategoryVO

interface BookDataAgent {
    fun getOverview(
        onSuccess : (List<ListBookCategoryVO>?) ->Unit,
        onFailure: (String) -> Unit
    )
}