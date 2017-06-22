package com.user.kotlin.mykotlin.api

import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.bean.JsonResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by PVer on 2017/6/21.
 */
interface GankApi{


    /**
     * Android所有数据
     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>

    /**
     * iOS所有数据
     */
    @GET("data/iOS/10/{page}")
    fun getiOSData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>

    /**
     * iOS所有数据
     */
    @GET("data/福利/10/{page}")
    fun getGirlData(@Path("page") page:Int):Observable<JsonResult<List<FuckGoods>>>


    @GET("random/data/{type}/1")
    fun getRandom(@Path("type") type:String):Observable<JsonResult<List<FuckGoods>>>
}