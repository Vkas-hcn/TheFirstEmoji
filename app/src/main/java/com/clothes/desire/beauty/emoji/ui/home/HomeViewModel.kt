package com.clothes.desire.beauty.emoji.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.FileOutputStream

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    fun shareImage(context: Context, bitmap: Bitmap) {
        try {
            // 2. 创建临时文件
            val cachePath = File(context.cacheDir, "shared_images")
            if (!cachePath.exists()) cachePath.mkdirs()

            val file = File.createTempFile("share_", ".png", cachePath)
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.flush()
            stream.close()

            // 3. 使用 FileProvider 生成 content:// URI
            val contentUri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )

            // 4. 构建分享 Intent
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, contentUri)
                type = "image/*"
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            // 5. 启动分享
            context.startActivity(Intent.createChooser(intent, "Share images"))

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("TAG", "shareImage: ${e.message}}", )
            Toast.makeText(context, "Failed to share: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

}