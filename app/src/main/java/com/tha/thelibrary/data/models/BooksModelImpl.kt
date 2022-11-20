package com.tha.thelibrary.data.models

import androidx.lifecycle.LiveData
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.data.vos.ListVO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object BooksModelImpl : BooksModel, BaseModel() {

    override fun getOverview(
        onSuccess: (List<ListVO>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mTheLibraryApi.getOverview()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.results?.lists?.forEach { listVO ->
                    // val listVO = listVO.books
                    onSuccess(it.results?.lists)
                    //   mLibraryDatabase?.BooksDao()?.insertBooks(listVO)
                }
            }, {
                onFailure(it.localizedMessage ?: "")
            })

    }

    override fun insertSingleBook(booksVO: BooksVO) {
        mLibraryDatabase?.booksDao()?.insertSingleBook(booksVO)
    }

    override fun getSaveBook(): LiveData<List<BooksVO>>? {
        return mLibraryDatabase?.booksDao()?.getAllBooks()
    }


}