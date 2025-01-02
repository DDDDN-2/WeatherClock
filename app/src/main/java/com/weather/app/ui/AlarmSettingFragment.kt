package com.weather.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.weather.app.WeatherApp
import com.weather.app.R
import com.weather.app.databinding.FragmentAlarmSettingBinding
import com.weather.app.db.AlarmEntity
import com.weather.app.ui.viewmodel.AlarmViewModel
import com.weather.app.ui.viewmodel.AlarmViewModelFactory
import com.weather.app.utils.AlarmManagerHelper
import java.util.*

class AlarmSettingFragment : DialogFragment() {
    private var _binding: FragmentAlarmSettingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AlarmViewModel by viewModels {
        AlarmViewModelFactory(
            repository = (requireActivity().application as WeatherApp).repository,
            alarmManagerHelper = AlarmManagerHelper(requireContext())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmSettingBinding.inflate(inflater, container, false)
        
        // 设置对话框宽度为屏幕宽度的90%
        dialog?.window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent)
            val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
            setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupTimePicker()
        setupWeekdayChips()
        setupSaveButton()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            // 关闭对话框
            dismiss()
        }
    }

    private fun setupTimePicker() {
        // 设置当前时间
        val calendar = Calendar.getInstance()
        binding.timePicker.hour = calendar.get(Calendar.HOUR_OF_DAY)
        binding.timePicker.minute = calendar.get(Calendar.MINUTE)
    }

    private fun setupWeekdayChips() {
        // 设置星期选择的点击事件
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {
            saveAlarm()
        }
    }

    private fun saveAlarm() {
        val hour = binding.timePicker.hour
        val minute = binding.timePicker.minute
        val label = binding.etLabel.text.toString()
        
        // 获取选中的重复日期
        val repeatDays = mutableListOf<Int>()
        // ... 获取选中的星期

        // 创建闹钟实体
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        val alarm = AlarmEntity(
            timeInMillis = calendar.timeInMillis,
            label = label,
            isEnabled = true,
            repeatDays = repeatDays.joinToString(",")
        )

        // 保存闹钟
        viewModel.insert(alarm)
        
        // 关闭对话框
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 