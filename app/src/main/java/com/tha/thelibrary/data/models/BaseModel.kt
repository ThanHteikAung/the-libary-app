package com.tha.thelibrary.data.models

import android.content.Context
import com.tha.thelibrary.network.TheBooksApi
import com.tha.thelibrary.persistence.BookDataBase
import com.tha.thelibrary.utils.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mTheBooksApi: TheBooksApi? = null
    protected var mBookDataBase: BookDataBase? = null

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
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        mTheBooksApi = retrofit.create(TheBooksApi::class.java)
    }

    fun initDatabase(context: Context) {
        mBookDataBase = BookDataBase.getDBInstance(context)
    }
}