package com.tha.thelibrary.network

import com.tha.thelibrary.network.responses.OverviewResponse
import com.tha.thelibrary.utils.API_GET_OVERVIEW
import com.tha.thelibrary.utils.LIBRARY_API_KEY
import com.tha.thelibrary.utils.PARAM_API_KEY
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface TheLibraryApi {

    @GET(API_GET_OVERVIEW)
    fun getOverview(
        @Query(PARAM_API_KEY) apiKey: String = LIBRARY_API_KEY
    ): Observable<OverviewResponse>
}