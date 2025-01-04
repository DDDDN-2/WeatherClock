package com.weather.app.ui.dialog

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.weather.app.R
import com.weather.app.databinding.DialogAlarmRingingBinding
import com.weather.app.service.AlarmService
import java.text.SimpleDateFormat
import java.util.*

class AlarmRingingDialog : DialogFragment() {
    private var _binding: DialogAlarmRingingBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogTheme)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAlarmRingingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val alarmId = arguments?.getInt("ALARM_ID", 0) ?: 0
        val label = arguments?.getString("ALARM_LABEL", "闹钟") ?: "闹钟"
        
        // 显示当前时间
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        binding.tvTime.text = timeFormat.format(Date())
        binding.tvLabel.text = label

        // 关闭闹钟
        binding.btnDismiss.setOnClickListener {
            stopAlarmService()
            dismiss()
        }

        // 稍后提醒（5分钟后）
        binding.btnSnooze.setOnClickListener {
            // TODO: 实现稍后提醒功能
            stopAlarmService()
            dismiss()
        }
    }

    private fun stopAlarmService() {
        requireContext().stopService(Intent(requireContext(), AlarmService::class.java))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(alarmId: Int, label: String): AlarmRingingDialog {
            return AlarmRingingDialog().apply {
                arguments = Bundle().apply {
                    putInt("ALARM_ID", alarmId)
                    putString("ALARM_LABEL", label)
                }
            }
        }
    }
} 