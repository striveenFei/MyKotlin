package com.user.kotlin.mykotlin.ui.fragment

import android.os.Bundle
import android.view.View
import com.user.kotlin.mykotlin.toast

/**
 * Created by PVer on 2017/6/21.
 */
class GirlFragment: BaseRecyclerFragment(){


    override fun initView(rootView: View) {
        super.initView(rootView)
        page = 1
        mPresenter.getData(page, GIRL)
    }

    companion object{
        val GIRL = "GIRL"
        fun newInstance(): GirlFragment{
            val fragment = GirlFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onItemClick(position: Int) {
        toast("ImageUrl:"+mList[position].url)
    }
}