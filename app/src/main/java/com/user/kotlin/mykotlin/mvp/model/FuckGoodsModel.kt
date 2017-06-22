package com.user.kotlin.mykotlin.mvp.model

import com.user.kotlin.mykotlin.api.GankApi
import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.bean.JsonResult
import com.user.kotlin.mykotlin.mvp.contract.FuckGoodsContract
import com.user.kotlin.mykotlin.ui.fragment.AndroidFragment
import com.user.kotlin.mykotlin.ui.fragment.GirlFragment
import com.user.kotlin.mykotlin.ui.fragment.IOSFragment
import rx.Observable

/**
 * Created by PVer on 2017/6/21.
 */
class FuckGoodsModel
constructor(private val api: GankApi): FuckGoodsContract.Model {
    override fun getData(page:Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        when (type) {
            IOSFragment.IOS -> return api.getiOSData(page)
            AndroidFragment.ANDROID -> return api.getAndroidData(page)
            GirlFragment.GIRL -> return api.getGirlData(page)
            else -> return api.getAndroidData(page)
        }
    }

}