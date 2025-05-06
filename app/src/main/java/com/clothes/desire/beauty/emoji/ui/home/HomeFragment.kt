package com.clothes.desire.beauty.emoji.ui.home

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Shader
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.createBitmap
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.clothes.desire.beauty.emoji.databinding.FragmentHomeBinding
import com.clothes.desire.beauty.emoji.utils.data.AppData
import java.io.File
import java.io.OutputStream

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var adapter: MixAdapter
    private val binding get() = _binding!!
    private var imageOneCreate = ""
    private var imageTwoCreate = ""
    var homeViewModel = HomeViewModel()
    private var click1 = 1
    private var click2 = 1

    companion object {
        private const val REQUEST_CODE_STORAGE_PERMISSION = 1001
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupRecyclerView()
        clickFun()
        return root
    }

    private fun setupRecyclerView() {
        val listData = AppData.getEmojiList(AppData.emoji1Json)
        adapter = MixAdapter(requireContext(), listData) { name ->
            when {
                imageOneCreate.isEmpty() -> {
                    imageOneCreate = name
                    click1 = binding?.clickInt ?: 0 // 使用安全调用操作符并提供默认值
                    mixImage1()
                }

                imageTwoCreate.isEmpty() -> {
                    imageTwoCreate = name
                    click2 = binding?.clickInt ?: 0 // 使用安全调用操作符并提供默认值
                    mixImage2()
                }
            }
            if (imageOneCreate.isNotBlank() && imageTwoCreate.isNotBlank()) {
                showMixDialog()
            }
        }
        binding.recyclerMix.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.recyclerMix.adapter = adapter
    }


    //逗号字符串转换为list
    private fun stringToList(string: String): List<String> {
        return string.split(",")
    }

    private fun mixImage1() {
        val oneList = stringToList(imageOneCreate)
        with(binding) {
            mix1Sate = true
            oneList[0].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixFace1.setImageResource(resId)
                } else {
                    imgMixFace1.setImageResource(0)
                }
            }
            oneList[1].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixEye1.setImageResource(resId)
                } else {
                    imgMixEye1.setImageResource(0)
                }
            }
            oneList[2].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixMouth1.setImageResource(resId)
                } else {
                    imgMixMouth1.setImageResource(0)
                }
            }
            oneList[3].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixHand1.setImageResource(resId)
                } else {
                    imgMixHand1.setImageResource(0)
                }
            }
        }
    }

    private fun mixImage2() {
        val oneList = stringToList(imageTwoCreate)
        with(binding) {
            mix2Sate = true
            oneList[0].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixFace2.setImageResource(resId)
                } else {
                    imgMixFace2.setImageResource(0)
                }
            }
            oneList[1].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixItemEye2.setImageResource(resId)
                } else {
                    imgMixItemEye2.setImageResource(0)
                }
            }
            oneList[2].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixItemMouth2.setImageResource(resId)
                } else {
                    imgMixItemMouth2.setImageResource(0)
                }
            }
            oneList[3].let {
                if (it.isNotBlank()) {
                    val resId =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixItemHand2.setImageResource(resId)
                } else {
                    imgMixItemHand2.setImageResource(0)
                }
            }
        }

    }


    private fun showMixDialog() {
        with(binding) {
            imgMixFaceResult.setImageResource(0)
            imgMixEyeResult.setImageResource(0)
            imgMixMouthResult.setImageResource(0)
            imgMixHandResult.setImageResource(0)
        }
        if (click1 == 1 || click2 == 1) {
            setImage1()
            return
        }
        if ((click1 == 2 || click1 == 3) && (click2 == 2 || click2 == 3)) {
            setImage3()
            return
        }
        setImage2()
    }

    private fun setImage1() {
        val oneList = stringToList(imageOneCreate)
        val twoList = stringToList(imageTwoCreate)
        with(binding) {
            llMixDialog.isVisible = true
            conFood.isInvisible = true
            flMixResult.isVisible = true
            twoList[0].let {
                if (it.isNotBlank()) {
                    val resIdFace =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixFaceResult.setImageResource(resIdFace)
                } else {
                    imgMixFaceResult.setImageResource(0)
                }
            }

            oneList[1].let {
                if (it.isNotBlank()) {
                    val resIdEye =
                        requireActivity().resources.getIdentifier(
                            oneList[1],
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixEyeResult.setImageResource(resIdEye)
                } else {
                    imgMixEyeResult.setImageResource(0)
                }
            }
            twoList[2].let {
                if (it.isNotBlank()) {
                    val resIdMouth =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixMouthResult.setImageResource(resIdMouth)
                } else {
                    imgMixMouthResult.setImageResource(0)
                }
            }

            twoList[3].let {
                if (it.isNotBlank()) {
                    val resIdMouth =
                        requireActivity().resources.getIdentifier(
                            it,
                            "drawable",
                            requireActivity().packageName
                        )
                    imgMixHandResult.setImageResource(resIdMouth)
                } else {
                    imgMixHandResult.setImageResource(0)
                }
            }
        }
    }

    private fun setImage2() {
        val oneList = stringToList(imageOneCreate)
        val twoList = stringToList(imageTwoCreate)
        with(binding) {
            llMixDialog.isVisible = true
            conFood.isInvisible = true
            flMixResult.isVisible = true
            val resIdFace = oneList[0].getImageFunData()
            val resIdEys = twoList[0].getImageFunData()
            if (resIdFace != null) {
                imgMixFaceResult.setImageResource(resIdFace)
            }
            if (resIdEys != null) {
                imgMixEyeResult.setImageResource(resIdEys)
            }
            imgMixMouthResult.setImageResource(0)
            imgMixHandResult.setImageResource(0)

        }
    }

    private fun setImage3() {
        val oneList = stringToList(imageOneCreate)
        val twoList = stringToList(imageTwoCreate)
        with(binding) {
            llMixDialog.isVisible = true
            conFood.isVisible = true
            flMixResult.isInvisible = false
            val resIdFace = oneList[0].getImageFunData()
            val resIdEys = twoList[0].getImageFunData()
            if (resIdFace != null) {
                imgMix1.setImageResource(resIdFace)
            }
            if (resIdEys != null) {
                imgMix2.setImageResource(resIdEys)
            }
        }
    }

    fun String.getImageFunData(): Int {
        return requireActivity().resources.getIdentifier(
            this,
            "drawable",
            requireActivity().packageName
        )
    }

    private fun clickFun() {
        with(binding) {
            checkItemEmoji(1)
            emojiItem1.setOnClickListener {
                checkItemEmoji(1)
            }
            emojiItem2.setOnClickListener {
                checkItemEmoji(2)
            }
            emojiItem3.setOnClickListener {
                checkItemEmoji(3)
            }
            emojiItem4.setOnClickListener {
                checkItemEmoji(4)
            }
            emojiItem5.setOnClickListener {
                checkItemEmoji(5)
            }
            emojiItem6.setOnClickListener {
                checkItemEmoji(6)
            }
            emojiItem7.setOnClickListener {
                checkItemEmoji(7)
            }
            imgRef.setOnClickListener {
                cleckMix()
            }
            imgXx.setOnClickListener {
                cloneDialog()
            }
            llMixDialog.setOnClickListener {

            }
            llDown.setOnClickListener {
                requestStoragePermission()
            }
            llShare.setOnClickListener {
                val view = binding.flMixResult
                val bitmap = createBitmap(view.width, view.height).apply {
                    val canvas = Canvas(this)
                    view.draw(canvas)
                }
                bitmap.let { it1 -> homeViewModel.shareImage(requireContext(), it1) }

            }
            img1.setOnClickListener {
                imageOneCreate = ""
                binding.mix1Sate = false
            }
            imgK2.setOnClickListener {
                imageTwoCreate = ""
                binding.mix2Sate = false
            }
        }
    }

    private fun cleckMix() {
        imageOneCreate = ""
        imageTwoCreate = ""
        binding.mix1Sate = false
        binding.mix2Sate = false
    }

    fun cloneDialog() {
        cleckMix()
        binding.llMixDialog.isVisible = false
    }

    private fun checkItemEmoji(state: Int) {
        binding.clickInt = state
        val json = when (state) {
            1 -> AppData.emoji1Json
            2 -> AppData.emoji2Json
            3 -> AppData.emoji3Json
            4 -> AppData.emoji4Json
            5 -> AppData.emoji5Json
            6 -> AppData.emoji6Json
            7 -> AppData.emoji7Json
            else -> AppData.emoji1Json
        }
        val listData = AppData.getEmojiList(json)
        adapter.submitList(listData)
    }

    private fun requestStoragePermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                downloadWallpaper()
            }

            shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
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

    private fun downloadWallpaper() {
        val view = if ((click1 == 2 || click1 == 3) && (click2 == 2 || click2 == 3)) {
            binding.conFood
        } else {
            binding.flMixResult
        }
        val bitmap = createBitmap(view.width, view.height).apply {
            val canvas = Canvas(this)
            view.draw(canvas)
        }
        val fileName = "emoji_${System.currentTimeMillis()}.png"
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(
                    MediaStore.Images.Media.RELATIVE_PATH,
                    Environment.DIRECTORY_PICTURES + File.separator + "Emoji"
                )
            }
        }
        val resolver = requireActivity().contentResolver
        var imageUri: Uri? = null
        try {
            imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            imageUri?.let { uri ->
                val fos: OutputStream? = resolver.openOutputStream(uri)
                fos?.use {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
                    Toast.makeText(
                        requireContext(),
                        "The picture has been saved",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    cloneDialog()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Failed to download Photo", Toast.LENGTH_SHORT).show()
            imageUri?.let { uri ->
                resolver.delete(uri, null, null)
            }
            cloneDialog()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                downloadWallpaper()
            } else {
                showPermissionDeniedDialog()
            }
        }
    }

    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Permission denied")
            .setMessage("Storage permissions are required to save pictures. Please enable storage permissions in the settings.")
            .setPositiveButton("Go to Settings") { _, _ ->
                openAppSettings()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun openAppSettings() {
        val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", requireActivity().packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        imageOneCreate = ""
        imageTwoCreate = ""
    }
}