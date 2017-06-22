package com.user.kotlin.mykotlin.ui.fragment

import android.os.Bundle
import android.view.View

/**
 * Created by PVer on 2017/6/21.
 */
class IOSFragment: BaseRecyclerFragment() {

    override fun initView(rootView: View) {
        super.initView(rootView)
        page = 1
        mPresenter.getData(page, IOS)
    }

    companion object {
        val IOS = "IOS"
        fun newInstance(): IOSFragment{
            val fragment = IOSFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}