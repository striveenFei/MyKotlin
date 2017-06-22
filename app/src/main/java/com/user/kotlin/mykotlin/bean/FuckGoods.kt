package com.user.kotlin.mykotlin.bean

/**
 * Created by PVer on 2017/6/21.
 */
data class FuckGoods(
        val  _id: String,
        val createdAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String
) {
    fun hasImg(): Boolean{
        return images != null
    }

    fun create() = createdAt.substring(0,10)
}