package com.tha.thelibrary.data.models

import android.content.Context
import com.tha.thelibrary.data.vos.ListBookCategoryVO
import com.tha.thelibrary.network.dataagents.BookDataAgent
import com.tha.thelibrary.network.dataagents.BookDataAgentImpl
import com.tha.thelibrary.persistence.BookDataBase

object BookModelImpl : BookModel {

    private val mBookDataAgent: BookDataAgent = BookDataAgentImpl

    private var mBookDataBase: BookDataBase? = null

     fun initDatabase(context: Context) {
        mBookDataBase = BookDataBase.getDBInstance(context)
    }

    override fun getOverview(
        onSuccess: (List<ListBookCategoryVO>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        onSuccess(mBookDataBase?.listBookCategoryDao()?.getListBookCategory() ?: listOf())
        mBookDataAgent.getOverview(onSuccess = {
            mBookDataBase?.listBookCategoryDao()?.insertListBookCategory(it ?: listOf())
            onSuccess(it)
        }, onFailure = onFailure)
    }
}