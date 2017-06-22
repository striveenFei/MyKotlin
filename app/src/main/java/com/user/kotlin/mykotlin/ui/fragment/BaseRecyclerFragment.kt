package com.user.kotlin.mykotlin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.user.kotlin.mykotlin.R
import com.user.kotlin.mykotlin.api.GankApi
import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.di.module.ApiModule
import com.user.kotlin.mykotlin.mvp.contract.FuckGoodsContract
import com.user.kotlin.mykotlin.mvp.model.FuckGoodsModel
import com.user.kotlin.mykotlin.mvp.presenter.FuckGoodsPresenter
import com.user.kotlin.mykotlin.router.GankClientUri
import com.user.kotlin.mykotlin.router.GankRouter
import com.user.kotlin.mykotlin.ui.adapter.FuckGoodsAdapter
import java.net.URLEncoder

/**
 * Created by PVer on 2017/6/21.
 */
abstract class BaseRecyclerFragment: BaseBidingFragment() , FuckGoodsContract.View{

    lateinit var recyclerView: RecyclerView

    lateinit var gankApi: GankApi
    var mList = ArrayList<FuckGoods>()
    override fun bindingContentView(): Int {
        return R.layout.view_recycler
    }

    lateinit var adapter: FuckGoodsAdapter
    lateinit var mPresenter : FuckGoodsPresenter
    var page: Int = 1

    override fun initView(rootView: View) {
        recyclerView = rootView.findViewById(R.id.recyclerView) as RecyclerView
        var layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        adapter = FuckGoodsAdapter(context, mList)
        adapter.setOnItemClickListener {
            position ->
            onItemClick(position)
        }

        recyclerView.adapter = adapter

        val apiModel = ApiModule(context)
        gankApi = apiModel.getGankApi()
        mPresenter = FuckGoodsPresenter(FuckGoodsModel(gankApi), this)
    }

    override fun setData(result: List<FuckGoods>) {
        mList.addAll(result)
        adapter.notifyDataSetChanged()
    }

    open fun onItemClick(position: Int){
        val url = URLEncoder.encode(mList[position].url)
        GankRouter.router(context, GankClientUri.DETAIL + url)
    }
}