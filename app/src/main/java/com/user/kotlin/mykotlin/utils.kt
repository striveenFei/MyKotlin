package com.user.kotlin.mykotlin

import android.content.Context
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast

/**
 * Created by PVer on 2017/6/21.
 */


fun Context.toast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, time).show()
}

fun Fragment.toast(msg: String, time: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this.context, msg, time).show()
}
fun logI(msg: String, tag:String = "TAG"){
    Log.i(tag,msg)
}