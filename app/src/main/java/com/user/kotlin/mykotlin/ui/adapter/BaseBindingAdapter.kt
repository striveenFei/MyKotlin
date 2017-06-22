package com.user.kotlin.mykotlin.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater


/**
 * Created by PVer on 2017/6/22.
 */
abstract class BaseBindingAdapter<T, Holder : BaseBindingAdapter.ViewHolder?>
constructor(context: Context, val mList: List<T>) : Adapter<Holder>() {
    var mInflater: LayoutInflater? = null

    init {
        mInflater = LayoutInflater.from(context)
    }

    abstract fun getLayoutId(viewType: Int): Int
    abstract fun getViewHolder(itemView: View, viewType: Int): Holder
    abstract fun onBindingData(viewHolder: Holder, position: Int, itemData: T)
    private var clickListener:((position: Int)->Unit)? = null

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view: View = mInflater?.inflate(getLayoutId(viewType), parent, false) as View
        return getViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (holder != null) {
            holder.itemView.setOnClickListener{
                if (clickListener != null)
                    clickListener?.invoke(holder.getAdapterPosition())
            }
        }
        onBindingData(holder, position, mList[position])
    }

    fun setOnItemClickListener(listener: ((position: Int)->Unit)){
        clickListener = listener
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}