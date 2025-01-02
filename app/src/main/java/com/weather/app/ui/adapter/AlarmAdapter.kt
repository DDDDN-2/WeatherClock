package com.weather.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weather.app.databinding.ItemAlarmBinding
import com.weather.app.db.AlarmEntity
import java.text.SimpleDateFormat
import java.util.*

class AlarmAdapter(
    private val onToggleAlarm: (AlarmEntity, Boolean) -> Unit,
    private val onDeleteAlarm: (AlarmEntity) -> Unit
) : ListAdapter<AlarmEntity, AlarmAdapter.ViewHolder>(AlarmDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAlarmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemAlarmBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(alarm: AlarmEntity) {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            binding.tvTime.text = timeFormat.format(Date(alarm.timeInMillis))
            binding.tvLabel.text = alarm.label
            binding.switchAlarm.isChecked = alarm.isEnabled

            binding.switchAlarm.setOnCheckedChangeListener { _, isChecked ->
                onToggleAlarm(alarm, isChecked)
            }

            binding.root.setOnLongClickListener {
                onDeleteAlarm(alarm)
                true
            }
        }
    }
}

private class AlarmDiffCallback : DiffUtil.ItemCallback<AlarmEntity>() {
    override fun areItemsTheSame(oldItem: AlarmEntity, newItem: AlarmEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AlarmEntity, newItem: AlarmEntity): Boolean {
        return oldItem == newItem
    }
} 