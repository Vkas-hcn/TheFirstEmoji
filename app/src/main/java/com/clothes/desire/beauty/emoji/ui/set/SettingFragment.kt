package com.clothes.desire.beauty.emoji.ui.set

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clothes.desire.beauty.emoji.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(SettingViewModel::class.java)

        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.imageView.setOnClickListener {
            requireActivity().finish()
        }
        binding.tvShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=${requireActivity().packageName}")
            try {
                startActivity(Intent.createChooser(intent, "Share via"))
            } catch (ex: Exception) {
                // Handle error
            }
        }
        binding.tvPp.setOnClickListener {
            val intent = Intent(Intent .ACTION_VIEW)
            intent.data = Uri.parse("https://sites.google.com/view/emojoy/home")
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}