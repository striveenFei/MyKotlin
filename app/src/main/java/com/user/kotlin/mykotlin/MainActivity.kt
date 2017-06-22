package com.user.kotlin.mykotlin

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.user.kotlin.mykotlin.bean.FuckGoods
import com.user.kotlin.mykotlin.di.module.ApiModule
import com.user.kotlin.mykotlin.mvp.contract.RandomContract
import com.user.kotlin.mykotlin.mvp.model.RandomModel
import com.user.kotlin.mykotlin.mvp.presenter.RandomPresenter
import com.user.kotlin.mykotlin.router.GankClientUri
import com.user.kotlin.mykotlin.router.GankRouter
import com.user.kotlin.mykotlin.ui.activity.BaseBindingActivity
import com.user.kotlin.mykotlin.ui.fragment.AndroidFragment
import com.user.kotlin.mykotlin.ui.fragment.FragmentHolder
import com.user.kotlin.mykotlin.ui.fragment.GirlFragment
import com.user.kotlin.mykotlin.ui.fragment.IOSFragment
import java.net.URLEncoder
import java.util.ArrayList

class MainActivity : BaseBindingActivity(), RandomContract.View {


    lateinit var viewPager: ViewPager
    lateinit var navigationView: BottomNavigationView
    lateinit var floatingButton: FloatingActionButton
    lateinit var mPresenter: RandomPresenter

    override fun bindingContentView(): Int {
        return R.layout.activity_main
    }

    lateinit var mFragments: MutableList<Fragment>
    override fun initView() {
        val apiModule = ApiModule(this)
        val gankApi = apiModule.getGankApi()

        mPresenter = RandomPresenter(RandomModel(gankApi), this)
        viewPager = findViewById(R.id.viewPager) as ViewPager
        navigationView = findViewById(R.id.navigationView) as BottomNavigationView
        floatingButton = findViewById(R.id.floatingButton) as FloatingActionButton


        initFragments()
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int) = mFragments[position]
            override fun getCount() = mFragments.size
        }

        viewPager.offscreenPageLimit = 4

        navigationView.setOnNavigationItemReselectedListener { item ->
            var tab = 0
            when (item.itemId) {
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            viewPager.currentItem = tab
            false
        }
        floatingButton.setOnClickListener { item ->
            mPresenter.getRandom("Android")
        }
    }

    override fun onRandom(goods: FuckGoods) {

        val url = URLEncoder.encode(goods.url)
        toast("手气不错～")
        logI("手气不错～")
        GankRouter.router(this, GankClientUri.DETAIL + url)
    }

    private fun initFragments() {
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(IOSFragment.newInstance())
        mFragments.add(GirlFragment.newInstance())
        mFragments.add(FragmentHolder())
    }

}
