package com.user.kotlin.mykotlin.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.user.kotlin.mykotlin.R

/**
 * Created by PVer on 2017/6/19.
 */

class MyFragment : Fragment() {

    lateinit var mView: View
    var conView: View? = null
//    internal var mView: View
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater?.inflate(R.layout.activity_main, container, false) as View
//        conView = inflater?.inflate(R.layout.activity_main, container, false) as View
        return mView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
