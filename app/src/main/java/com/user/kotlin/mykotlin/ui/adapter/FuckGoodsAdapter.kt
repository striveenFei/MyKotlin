package com.user.kotlin.mykotlin.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.user.kotlin.mykotlin.R
import com.user.kotlin.mykotlin.bean.FuckGoods

/**
 * Created by PVer on 2017/6/22.
 */
class FuckGoodsAdapter(context: Context, mList: List<FuckGoods>): BaseBindingAdapter<FuckGoods, BaseBindingAdapter.ViewHolder>(context, mList) {


    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_fuckgoods
    }

    override fun getViewHolder(itemView: View, viewType: Int): ViewHolder {
        return FuckGoodsViewHolder(itemView)
    }

    override fun onBindingData(viewHolder: ViewHolder, position: Int, itemData: FuckGoods) {

        val holder = viewHolder as FuckGoodsViewHolder
//        holder.goodsDesc.setText(itemData.desc)
        holder.goodsWho.setText(itemData.who)
        holder.goodsCreate.setText(itemData.create())
        holder.goodsDesc.text = itemData.desc
        holder.goodsHasImg.visibility = if (itemData.hasImg()) View.VISIBLE else View.GONE
    }

    class FuckGoodsViewHolder(itemView: View): ViewHolder(itemView){

        val goodsDesc: TextView
        val goodsWho : TextView
        val goodsCreate : TextView
        val goodsHasImg : ImageView
        init {
            goodsDesc = itemView.findViewById(R.id.goods_desc) as TextView
            goodsWho = itemView.findViewById(R.id.goods_who) as TextView
            goodsCreate = itemView.findViewById(R.id.goods_create) as TextView
            goodsHasImg = itemView.findViewById(R.id.goods_has_img) as ImageView
        }
    }
}