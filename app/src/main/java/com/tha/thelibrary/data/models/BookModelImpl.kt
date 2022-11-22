package com.tha.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.tha.thelibrary.data.vos.ListBookCategoryVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object BookModelImpl : BookModel, BaseModel() {

    override fun getOverview(onFailure: (String) -> Unit): LiveData<List<ListBookCategoryVO>>? {

        //Network
        mTheBooksApi?.getOverview()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                it.results?.lists?.let { listBookCategory ->
                    //DataBase insert
                    mBookDataBase?.listBookCategoryDao()?.insertListBookCategory(listBookCategory)
                }
            }, {
                onFailure(it.localizedMessage ?: "")
            })
        return mBookDataBase?.listBookCategoryDao()?.getListBookCategory()
    }
}