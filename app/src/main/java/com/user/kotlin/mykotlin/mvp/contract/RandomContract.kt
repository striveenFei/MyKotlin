package com.user.kotlin.mykotlin.mvp.contract

import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.bean.JsonResult
import rx.Observable

/**
 * Created by PVer on 2017/6/21.
 */
interface RandomContract{

    interface View{
        fun onRandom(fuckGoods: FuckGoods)
    }

    interface Model {
        fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter{
        fun getRandom(type: String)
    }
}