package com.user.kotlin.mykotlin.mvp.model

import com.user.kotlin.mykotlin.api.GankApi
import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.bean.JsonResult
import com.user.kotlin.mykotlin.mvp.contract.RandomContract
import rx.Observable

/**
 * Created by PVer on 2017/6/21.
 */
class RandomModel
constructor(private val api: GankApi): RandomContract.Model{
    override fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
    }

}