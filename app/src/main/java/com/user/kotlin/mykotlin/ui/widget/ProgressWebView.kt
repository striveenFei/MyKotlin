package com.user.kotlin.mykotlin.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AbsoluteLayout
import android.widget.ProgressBar
import com.user.kotlin.mykotlin.R

/**
 * Created by PVer on 2017/6/21.
 */
class ProgressWebView(context: Context, attrs: AttributeSet) :WebView(context, attrs){

    private val progressBar: ProgressBar

    init {
        progressBar = ProgressBar(context,null, android.R.attr.progressBarStyleHorizontal)
        progressBar.layoutParams = AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.FILL_PARENT,
                10, 0, 0)

        val drawable = context.resources.getDrawable(R.drawable.progress_bar)
        progressBar.progressDrawable = drawable
        addView(progressBar)
        setWebChromeClient(WebChromeClient())
        setWebViewClient(object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
               view?.loadUrl(url)
                return true
            }
        })
    }

    inner class WebChromeClient : android.webkit.WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            if (newProgress == 100) {
                progressBar.visibility = View.GONE
            } else {
                if (progressBar.visibility == View.GONE)
                    progressBar.visibility = View.VISIBLE
                progressBar.progress = newProgress
            }
            super.onProgressChanged(view, newProgress)
        }

    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        val lp = progressBar.layoutParams as AbsoluteLayout.LayoutParams
        lp.x = l
        lp.y = t
        progressBar.layoutParams = lp
        super.onScrollChanged(l, t, oldl, oldt)
    }
}