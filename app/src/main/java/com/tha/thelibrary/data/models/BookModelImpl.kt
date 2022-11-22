package com.tha.thelibrary.data.models

import com.tha.thelibrary.data.vos.ListBookCategoryVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object BookModelImpl : BookModel, BaseModel() {

    override fun getOverview(
        onSuccess: (List<ListBookCategoryVO>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        //DataBase
        onSuccess(mBookDataBase?.listBookCategoryDao()?.getListBookCategory() ?: listOf())

        //Network
        mTheBooksApi?.getOverview()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                it.results?.lists?.let { listBookCategory ->
                    //DataBase insert
                    mBookDataBase?.listBookCategoryDao()?.insertListBookCategory(listBookCategory)
                    onSuccess(listBookCategory)
                }
            }, {
                onFailure(it.localizedMessage ?: "")
            })
    }
}