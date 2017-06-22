package com.user.kotlin.mykotlin.mvp.presenter

import com.user.kotlin.mykotlin.mvp.contract.RandomContract
import com.user.kotlin.mykotlin.mvp.model.RandomModel
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by PVer on 2017/6/21.
 */
class RandomPresenter
    constructor(private val model:RandomModel,
                private val view: RandomContract.View): BasePresenter(),RandomContract.Presenter{
    override fun getRandom(type: String) {
        addSubscription(model.getRandom(type).observeOn(AndroidSchedulers.mainThread()).
                subscribe({
                    res->
                   if (! res.error)
                       view.onRandom(res.results[0])
                })
        )
    }

}