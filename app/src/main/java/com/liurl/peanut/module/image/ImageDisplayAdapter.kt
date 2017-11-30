package com.liurl.peanut.module.image

import android.content.Context
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.liurl.peanut.R

/**
 * @author liuruilin
 * @data 2017/11/3
 * @describe
 */
class ImageDisplayAdapter(private val mContext: Context, private val listener: ImageItemClickListener, private val limit: Int): RecyclerView.Adapter<ImageDisplayAdapter.ImageDisplayHolder>() {
    var mData = mutableListOf<Uri>()

    override fun getItemCount(): Int = mData.size + 1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageDisplayHolder {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false)
        return ImageDisplayHolder(inflate)
    }

    override fun onBindViewHolder(holder: ImageDisplayHolder?, position: Int) {
        when {
            itemCount == limit + 1 && position == limit -> {
                setAddImageDisplayView(holder)
                holder!!.rlImageDisplayItem.visibility = View.GONE
            }

            position == itemCount - 1 -> {
                setAddImageDisplayView(holder)
            }

            else -> {
                TODO("图片显示逻辑 -> YH -> FeedbackPageScreenshotAdapter")
            }
        }
    }

    fun setData(data: List<Uri>?) {
        mData.addAll(data!!)
        notifyDataSetChanged()
    }

    fun getData(): List<Uri> = mData

    fun deleteImageWithPos(mPos: Int) {
        mData.removeAt(mPos)
        notifyDataSetChanged()
    }

    private fun setAddImageDisplayView(holder: ImageDisplayHolder?) {
        holder!!.rlImageDisplayItem.visibility = View.VISIBLE

        TODO("图片资源待添加")
        holder.ivImageAdd.setImageDrawable(ContextCompat.getDrawable(mContext,0))
        holder.ivImageDelete.visibility = View.GONE
        holder.ivImageAdd.setOnClickListener { listener.addImage(limit + 1 - itemCount) }
    }

    class ImageDisplayHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rlImageDisplayItem = itemView.findViewById<LinearLayout>(R.id.ll_image_display_item)
        var ivImageAdd = itemView.findViewById<ImageView>(R.id.iv_image_add)
        var ivImageDelete = itemView.findViewById<ImageView>(R.id.iv_image_delete)
    }

    interface ImageItemClickListener {
        fun addImage(maxNum: Int)
        fun deleteImage(pos: Int)
    }
}