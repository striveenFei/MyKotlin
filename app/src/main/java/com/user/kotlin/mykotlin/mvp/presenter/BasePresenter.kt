package com.user.kotlin.mykotlin.mvp.presenter

import rx.subscriptions.CompositeSubscription
import rx.Subscription

/**
 * Created by PVer on 2017/6/21.
 */
open class BasePresenter{

    var compositeSubscription = CompositeSubscription()

    protected fun addSubscription(subscription: Subscription){
        compositeSubscription.add(subscription)
    }

    fun unSubscribe(){
        if (compositeSubscription.hasSubscriptions())
            compositeSubscription.unsubscribe()
    }
}