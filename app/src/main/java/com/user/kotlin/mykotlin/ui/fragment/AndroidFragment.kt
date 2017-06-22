package com.user.kotlin.mykotlin.ui.fragment

import android.os.Bundle
import android.view.View

/**
 * Created by PVer on 2017/6/19.
 */

class AndroidFragment : BaseRecyclerFragment(){

    override fun initView(rootView: View) {
        super.initView(rootView)
        page = 1
        mPresenter.getData(page, ANDROID)
    }

    companion object{
        val ANDROID = "ANDROID"
        fun newInstance():AndroidFragment{
            var fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}