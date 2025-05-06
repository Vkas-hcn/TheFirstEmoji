package com.clothes.desire.beauty.emoji.ui.down

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clothes.desire.beauty.emoji.databinding.FragmentDownloadBinding
import com.clothes.desire.beauty.emoji.ui.home.HomeViewModel
import com.clothes.desire.beauty.emoji.utils.data.AppData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.OutputStream
import kotlin.properties.Delegates

class DownloadFragment : Fragment(), ActivityCompat.OnRequestPermissionsResultCallback {

    private var isBatchDownload = false
    private var _binding: FragmentDownloadBinding? = null
    private val binding get() = _binding!!
    private var selectedImageResId by Delegates.notNull<Int>()
    private var iconDown:List<Int> = listOf()
    companion object {
        private const val REQUEST_CODE_STORAGE_PERMISSION = 1001
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDownloadBinding.inflate(inflater, container, false)
        val downloadViewModel =
            ViewModelProvider(this).get(DownloadViewModel::class.java)

        setupRecyclerView(AppData.iconDown1,binding.rvDown1)
        setupRecyclerView(AppData.iconDown2,binding.rvDown2)
        setupRecyclerView(AppData.iconDown3,binding.rvDown3)
        setupRecyclerView(AppData.iconDown4,binding.rvDown4)
        setupRecyclerView(AppData.iconDown5,binding.rvDown5)
        setupRecyclerView(AppData.iconDown6,binding.rvDown6)
        setupRecyclerView(AppData.iconDown7,binding.rvDown7)
        setupRecyclerView(AppData.iconDown8,binding.rvDown8)
        binding.imgDownload1All.setOnClickListener {
            clickAllDown(AppData.iconDown1)
        }
        binding.imgDownload2All.setOnClickListener {
            clickAllDown(AppData.iconDown2)
        }
        binding.imgDownload3All.setOnClickListener {
            clickAllDown(AppData.iconDown3)
        }
        binding.imgDownload4All.setOnClickListener {
            clickAllDown(AppData.iconDown4)
        }

        binding.imgDownload5All.setOnClickListener {
            clickAllDown(AppData.iconDown5)
        }
        binding.imgDownload6All.setOnClickListener {
            clickAllDown(AppData.iconDown6)
        }
        binding.imgDownload7All.setOnClickListener {
            clickAllDown(AppData.iconDown7)
        }
        binding.imgDownload8All.setOnClickListener {
            clickAllDown(AppData.iconDown8)
        }
        binding.llDown.setOnClickListener {
            requestStoragePermission()
        }
        binding.llShare.setOnClickListener {
            downloadViewModel.shareImage(requireContext(), selectedImageResId)
        }
        binding.imgXx.setOnClickListener {
            binding.llDownDialog.isVisible = false
        }
        binding.llDownDialog.setOnClickListener {  }
        return binding.root
    }


    private fun clickAllDown(data:List<Int> ){
        selectedImageResId= data.getOrNull(0)?:0
        isBatchDownload = true
        iconDown = data
        showImageIcon(true)
    }
    private fun showImageIcon(isALl:Boolean){
        with(binding){
            if(isALl){
                tvDownTips.isVisible = true
                imgDownRe.isInvisible = true
            }else{
                binding.imgDownRe.setImageResource(selectedImageResId)
                tvDownTips.isVisible = false
                imgDownRe.isVisible = true
            }
            binding.llDownDialog.isVisible = true
        }

    }

    private fun clickItemDown(data:Int ){
        selectedImageResId = data
        isBatchDownload = false
        showImageIcon(false)
    }


    private fun setupRecyclerView(datList: List<Int>,recyclerView: RecyclerView) {
        val adapter = DownloadAdapter(requireContext(), datList) { resId ->
            clickItemDown(resId)
        }
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 5)
        recyclerView.adapter = adapter
    }



    private fun requestStoragePermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                // 权限已授予，直接下载
                downFun()
            }

            shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                // 用户之前拒绝过权限请求，显示解释对话框
                showPermissionDeniedDialog()
            }

            else -> {
                // 请求权限
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE_STORAGE_PERMISSION
                )
            }
        }
    }

    private fun downFun() {
        if (isBatchDownload) {
            startBatchDownload()
        } else {
            val state = downloadWallpaper(selectedImageResId)
            if (state) {
                Toast.makeText(requireContext(), "The picture has been saved", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Failed to save the image", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.llDownDialog.isVisible = false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 权限授予成功
                downFun()
            } else {
                // 权限被拒绝
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // 用户勾选了 "不再询问"，引导跳转设置页
                    showPermissionDeniedDialog()
                } else {
                    Toast.makeText(requireContext(), "权限未授予", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(requireActivity())
            .setTitle("Permission Denied")
            .setMessage("Storage permission is required to download Image. Please grant the permission in settings.")
            .setPositiveButton("Settings") { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", requireActivity().packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    //  保存图片到相册
    private fun downloadWallpaper(drawableResId: Int): Boolean {
        val drawable = ContextCompat.getDrawable(requireContext(), drawableResId) ?: return false
        val bitmap = (drawable as? BitmapDrawable)?.bitmap ?: drawable.toBitmap()

        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "emoji_${System.currentTimeMillis()}.png")
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(
                    MediaStore.Images.Media.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES + File.separator + "EmojiCollection"
                )
            }
        }

        val resolver = requireActivity().contentResolver
        var imageUri: Uri? = null
        try {
            imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            imageUri?.let { uri ->
                resolver.openOutputStream(uri)?.use { fos ->
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                }
            }
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            imageUri?.let { resolver.delete(it, null, null) }
            return false
        }
    }


    private fun startBatchDownload() {
        val context = requireContext()
        val successList = mutableListOf<String>()
        val failedList = mutableListOf<String>()

        CoroutineScope(Dispatchers.IO).launch {
            iconDown.forEachIndexed { index, resId ->
                val result = downloadWallpaper(resId)
                withContext(Dispatchers.Main) {
                    if (result) successList.add("The ${index + 1} emoji")
                    else failedList.add("The ${index + 1} emoji")
                }
            }

            withContext(Dispatchers.Main) {
                val message = buildString {
                    append("A total of ${successList.size} emojis have been saved to the album\n")
                    if (failedList.isNotEmpty()) {
                        append("The following sticker pack failed to be saved：\n")
                        failedList.forEach { append("- $it\n") }
                    }
                }
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                binding.llDownDialog.isVisible = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
