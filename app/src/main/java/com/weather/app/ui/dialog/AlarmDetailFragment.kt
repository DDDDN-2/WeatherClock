package com.weather.app.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.weather.app.databinding.FragmentAlarmDetailBinding
import com.weather.app.ui.viewmodel.AlarmViewModel
import com.weather.app.db.AlarmEntity
import java.text.SimpleDateFormat
import java.util.*

class AlarmDetailFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentAlarmDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AlarmViewModel by activityViewModels()

    private val weatherTypes = listOf("雨", "雪", "雾", "大风")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupWeatherTypeSpinner()
        
        val alarmId = arguments?.getInt(ARG_ALARM_ID) ?: return
        
        viewModel.getAlarmById(alarmId).observe(viewLifecycleOwner) { alarm ->
            alarm?.let {
                binding.apply {
                    tvTime.text = SimpleDateFormat("HH:mm", Locale.getDefault())
                        .format(Date(alarm.timeInMillis))
                    tvLabel.text = alarm.label
                    switchAlarm.isChecked = alarm.isEnabled
                    
                    // 设置天气感知相关UI
                    switchWeatherAware.isChecked = alarm.weatherAwareEnabled
                    layoutWeatherSettings.visibility = 
                        if (alarm.weatherAwareEnabled) View.VISIBLE else View.GONE
                    
                    spinnerWeatherType.setSelection(
                        weatherTypes.indexOf(alarm.weatherType).takeIf { it >= 0 } ?: 0
                    )
                    etAdvanceMinutes.setText(alarm.advanceMinutes.toString())
                }
            }
        }

        // 监听天气感知开关
        binding.switchWeatherAware.setOnCheckedChangeListener { _, isChecked ->
            binding.layoutWeatherSettings.visibility = if (isChecked) View.VISIBLE else View.GONE
            updateAlarm(alarmId)
        }

        // 监听天气类型选择
        binding.spinnerWeatherType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateAlarm(alarmId)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // 监听提前分钟数变化
        binding.etAdvanceMinutes.doAfterTextChanged { 
            updateAlarm(alarmId)
        }

        // 监听闹钟启用状态
        binding.switchAlarm.setOnCheckedChangeListener { _, isChecked ->
            updateAlarm(alarmId)
        }
    }

    private fun setupWeatherTypeSpinner() {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            weatherTypes
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spinnerWeatherType.adapter = adapter
    }

    private fun updateAlarm(alarmId: Int) {
        viewModel.getAlarmById(alarmId).value?.let { alarm ->
            val updatedAlarm = alarm.copy(
                isEnabled = binding.switchAlarm.isChecked,
                weatherAwareEnabled = binding.switchWeatherAware.isChecked,
                weatherType = weatherTypes[binding.spinnerWeatherType.selectedItemPosition],
                advanceMinutes = binding.etAdvanceMinutes.text.toString().toIntOrNull() ?: 0,
                timeInMillis = alarm.timeInMillis,
                label = alarm.label,
                repeatDays = alarm.repeatDays
            )
            viewModel.update(updatedAlarm)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_ALARM_ID = "alarm_id"

        fun newInstance(alarmId: Int) = AlarmDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ALARM_ID, alarmId)
            }
        }
    }
} 