package com.user.kotlin.mykotlin.di.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.user.kotlin.mykotlin.api.GankApi
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.io.File

/**
 * Created by PVer on 2017/6/16.
 */
class ApiModule
constructor(context: Context){
    init {
        initRetrofit( getOkHttpClient(context, provideInterceptor()))
    }

    lateinit var retrofit: Retrofit
    fun initRetrofit(client: OkHttpClient){

        retrofit =  Retrofit.Builder()
                .client(client)
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    fun getOkHttpClient(context: Context,interceptor: HttpLoggingInterceptor): OkHttpClient{
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor).build()
    }

    fun provideInterceptor() :HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


    fun getBaseUrl(): HttpUrl {
        return HttpUrl.parse("http://gank.io/api/")
    }

    fun getGson(): Gson{
        return GsonBuilder().create()
    }

    fun getGankApi() = retrofit.create(GankApi::class.java)
}