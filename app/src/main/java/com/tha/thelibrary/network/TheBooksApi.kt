package com.tha.thelibrary.network

import com.tha.thelibrary.network.responses.BooksListResponse
import com.tha.thelibrary.utils.API_GET_LIST_OVERVIEW
import com.tha.thelibrary.utils.BOOKS_API_KEY
import com.tha.thelibrary.utils.PARAM_API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TheBooksApi {

    @GET(API_GET_LIST_OVERVIEW)
    fun getOverview(
        @Query(PARAM_API_KEY) apiKey: String = BOOKS_API_KEY
    ): Observable<BooksListResponse>

}