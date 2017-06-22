package com.user.kotlin.mykotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.user.kotlin.mykotlin.R

/**
 * Created by PVer on 2017/6/16.
 */
abstract class BaseBindingActivity : AppCompatActivity() {

    abstract fun bindingContentView():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingContentView())
        initCreate(savedInstanceState)
        initView()
    }

    open fun initCreate(savedInstanceState: Bundle?){

    }

    open fun initView(){

    }

    fun aaaa():Int{
        var asa = 1
        return asa
    }

    fun setUpToolbar(toolbar: Toolbar){
        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.icon_back)
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}