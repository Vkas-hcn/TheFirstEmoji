package com.clothes.desire.beauty.emoji.ui.home


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clothes.desire.beauty.emoji.R
import com.clothes.desire.beauty.emoji.utils.data.EmojiBean
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class MixAdapter(
    private val context: Context,
    private var imageResIds: EmojiBean,
    private val onItemClickListener: (String) -> Unit
) : RecyclerView.Adapter<MixAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mix_image, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).clear(holder.imgMixFace)
        Glide.with(context).clear(holder.imgMixItemEye)
        Glide.with(context).clear(holder.imgMixItemMouth)
        Glide.with(context).clear(holder.imgMixItemHand)
        // 安全获取资源名称（防止越界）
        val faceName = if (position < imageResIds.face.size) imageResIds.face[position] else ""
        val eyeName = if (position < imageResIds.eye.size) imageResIds.eye[position] else ""
        val mouthName = if (position < imageResIds.mouth.size) imageResIds.mouth[position] else ""
        val handName = if (position < imageResIds.hand.size) imageResIds.hand[position] else ""
        holder.imgMixFace.tag = faceName
        // 加载资源（仅加载非空名称的资源）
        if (faceName != null && faceName.isNotEmpty() && holder.imgMixFace.tag == faceName) {
            val resId =
                context.resources.getIdentifier(faceName, "drawable", context.packageName)
            holder.imgMixFace.setImageResource(resId)
        }
        if (eyeName != null && eyeName.isNotEmpty()) {
            val resId = context.resources.getIdentifier(eyeName, "drawable", context.packageName)
            Glide.with(context).load(resId).into(holder.imgMixItemEye)
        }
        if (mouthName != null && mouthName.isNotEmpty()) {
            val resId = context.resources.getIdentifier(mouthName, "drawable", context.packageName)
            Glide.with(context).load(resId).into(holder.imgMixItemMouth)
        }
        if (handName != null && handName.isNotEmpty()) {
            val resId = context.resources.getIdentifier(handName, "drawable", context.packageName)
            Glide.with(context).load(resId).into(holder.imgMixItemHand)
        }



        holder.itemView.setOnClickListener {
            val mixName = "${faceName},${eyeName},${mouthName},${handName}"
            onItemClickListener(mixName)
        }
    }

    override fun getItemCount(): Int = imageResIds.face.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMixFace: ImageView = itemView.findViewById(R.id.img_mix_face)
        val imgMixItemEye: ImageView = itemView.findViewById(R.id.img_mix_item_eye)
        val imgMixItemMouth: ImageView = itemView.findViewById(R.id.img_mix_item_mouth)
        val imgMixItemHand: ImageView = itemView.findViewById(R.id.img_mix_item_hand)
    }

    //更新列表数据
    fun submitList(newList: EmojiBean) {
        imageResIds = newList
        notifyDataSetChanged()
    }
}
