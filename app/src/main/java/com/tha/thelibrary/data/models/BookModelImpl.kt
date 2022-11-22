package com.tha.thelibrary.data.models

import com.tha.thelibrary.data.vos.ListBookCategoryVO
import com.tha.thelibrary.network.dataagents.BookDataAgent
import com.tha.thelibrary.network.dataagents.BookDataAgentImpl

class BookModelImpl : BookModel {

    private val mBookDataAgent: BookDataAgent = BookDataAgentImpl

    override fun getOverview(
        onSuccess: (List<ListBookCategoryVO>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mBookDataAgent.getOverview(onSuccess = onSuccess, onFailure = onFailure)
    }
}