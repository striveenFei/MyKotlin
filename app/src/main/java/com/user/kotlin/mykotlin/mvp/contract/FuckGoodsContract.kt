package com.user.kotlin.mykotlin.mvp.contract

import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.bean.JsonResult
import rx.Observable

/**
 * Created by PVer on 2017/6/21.
 */
interface FuckGoodsContract{

    interface View{
       fun setData(result: List<FuckGoods>)
    }

    interface Model{
        fun getData(page: Int, type: String):Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter{
        fun getData(page: Int, type: String)
    }
}