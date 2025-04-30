package com.clothes.desire.beauty.emoji.ui.down


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
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
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class DownloadAdapter(
    private val context: Context,
    private val imageResIds: List<Int>,
    private val onItemClickListener: (Int) -> Unit // 新增回调
) : RecyclerView.Adapter<DownloadAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_download_image, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resId = imageResIds[position]

        Glide.with(context).load(resId).into(holder.imageView)

        holder.itemView.setOnClickListener {
            onItemClickListener(resId) // 触发回调
        }
    }

    override fun getItemCount(): Int = imageResIds.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_download_item)
    }
}
