package com.clothes.desire.beauty.emoji.ui.ac

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.clothes.desire.beauty.emoji.R

import com.clothes.desire.beauty.emoji.databinding.ActivityGuideBinding
import com.clothes.desire.beauty.emoji.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        onBackPressedDispatcher.addCallback {
        }

        startProgress()
    }
    private fun startProgress() {
        lifecycleScope.launch {
            while (true){
                binding.sP.incrementProgressBy(1)
                delay(20)
                if (binding.sP.progress == 100) {
                    jumpToMain()
                    break
                }
            }
        }
    }

    private fun jumpToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}