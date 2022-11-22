package com.tha.thelibrary.network.dataagents

import com.tha.thelibrary.data.vos.ListBookCategoryVO
import com.tha.thelibrary.network.TheBooksApi
import com.tha.thelibrary.network.responses.BooksListResponse
import com.tha.thelibrary.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object BookDataAgentImpl : BookDataAgent {

    private var mTheBooksApi: TheBooksApi? = null

    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mTheBooksApi = retrofit.create(TheBooksApi::class.java)

    }

    override fun getOverview(
        onSuccess: (List<ListBookCategoryVO>?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mTheBooksApi?.getOverview()
            ?.enqueue(object : Callback<BooksListResponse> {
                override fun onResponse(
                    call: Call<BooksListResponse>,
                    response: Response<BooksListResponse>
                ) {
                    if (response.isSuccessful) {
                        val listBooksCategory = response.body()?.results?.lists
                        onSuccess(listBooksCategory)
                    }else{
                        onFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<BooksListResponse>, t: Throwable) {
                    println(t.message ?: "")
                }

            })
    }
}