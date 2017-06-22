package com.user.kotlin.mykotlin.ui.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by PVer on 2017/6/16.
 */
class NoScrollViewPager : ViewPager{
    private val isPagingEnabled = false
    constructor(content: Context): super(content){
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event)
    }
}