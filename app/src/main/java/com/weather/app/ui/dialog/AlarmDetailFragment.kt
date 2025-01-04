package com.weather.app.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.weather.app.databinding.FragmentAlarmDetailBinding
import com.weather.app.ui.viewmodel.AlarmViewModel
import java.text.SimpleDateFormat
import java.util.*

class AlarmDetailFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentAlarmDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AlarmViewModel by activityViewModels()

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
        
        val alarmId = arguments?.getInt(ARG_ALARM_ID) ?: return
        
        viewModel.getAlarmById(alarmId).observe(viewLifecycleOwner) { alarm ->
            alarm?.let {
                binding.apply {
                    tvTime.text = SimpleDateFormat("HH:mm", Locale.getDefault())
                        .format(Date(alarm.timeInMillis))
                    tvLabel.text = alarm.label
                    switchAlarm.isChecked = alarm.isEnabled
                }
            }
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