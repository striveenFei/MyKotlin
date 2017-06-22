package com.user.kotlin.mykotlin.ui.activity

import com.airbnb.deeplinkdispatch.DeepLink
import com.user.kotlin.mykotlin.R
import com.user.kotlin.mykotlin.router.GankClientUri

/**
 * Created by PVer on 2017/6/22.
 */
@DeepLink("gank://androidwing.net/detail/{${GankClientUri.ABOUT}}")
class AboutActivity: BaseBindingActivity() {
    override fun bindingContentView(): Int {
        return R.layout.activity_about
    }
}