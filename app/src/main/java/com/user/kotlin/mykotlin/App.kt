package com.user.kotlin.mykotlin

import android.app.Application

/**
 * Created by PVer on 2017/6/16.
 */
class App : Application(){
    override fun onCreate() {
        super.onCreate()
    }

    init {
        instance = this
    }

    companion object{
        lateinit var instance: App
    }
}