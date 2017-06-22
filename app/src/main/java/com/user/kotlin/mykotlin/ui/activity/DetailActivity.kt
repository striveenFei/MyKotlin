package com.user.kotlin.mykotlin.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.airbnb.deeplinkdispatch.DeepLink
import com.user.kotlin.mykotlin.R
import com.user.kotlin.mykotlin.router.GankClientUri
import com.user.kotlin.mykotlin.ui.widget.ProgressWebView
import java.net.URLDecoder

/**
 * Created by PVer on 2017/6/21.
 */


@DeepLink("gank://androidwing.net/detail/{${GankClientUri.DETAIL_PARAM_URL}}")
class DetailActivity : BaseBindingActivity() {
    override fun bindingContentView(): Int {
        return R.layout.activity_detail
    }

    var url =""
    lateinit var toolbar: Toolbar
    lateinit var webView: ProgressWebView
    lateinit var tv_title: TextView
    override fun initCreate(savedInstanceState: Bundle?) {
        super.initCreate(savedInstanceState)

        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)){
            url = URLDecoder.decode(intent.extras.getString(GankClientUri.DETAIL_PARAM_URL))
        }
        toolbar = findViewById(R.id.toolbar) as Toolbar
        webView = findViewById(R.id.webView) as ProgressWebView
        tv_title = findViewById(R.id.tv_title) as TextView
        setUpToolbar(toolbar)

        tv_title.setText("Gank.io")
        webView.loadUrl(url)
    }

}