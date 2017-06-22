package com.user.kotlin.mykotlin.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by PVer on 2017/6/19.
 */

abstract class BaseBidingFragment : Fragment(){

    lateinit var mRootView : View
    abstract fun bindingContentView():Int
    abstract fun initView(rootView: View)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         mRootView  = inflater?.inflate(bindingContentView(), container, false) as View
        initView(mRootView)
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    open fun initCreate(savedInstanceState: Bundle?){

    }
}