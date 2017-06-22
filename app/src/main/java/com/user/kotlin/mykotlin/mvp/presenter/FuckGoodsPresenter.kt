package com.user.kotlin.mykotlin.mvp.presenter

import com.user.kotlin.mykotlin.mvp.contract.FuckGoodsContract
import com.user.kotlin.mykotlin.mvp.model.FuckGoodsModel
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by PVer on 2017/6/22.
 */
class FuckGoodsPresenter
constructor(private val mModel: FuckGoodsModel,
            private val mView: FuckGoodsContract.View) : FuckGoodsContract.Presenter {
    override fun getData(page: Int, type: String) {

        mModel.getData(page, type).observeOn(AndroidSchedulers.mainThread()).subscribe({
            result ->
            if (!result.error)
                mView.setData(result.results)
        })
    }
}