package com.weather.app.ui.helper

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.MotionEvent
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeToDeleteCallback(
    private val onDelete: (Int) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    private val deleteButtonWidth = 200f
    private var currentlyShownItem: Int = -1

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // 记录当前展开的项
        currentlyShownItem = viewHolder.adapterPosition
        setupTouchListener(viewHolder.itemView.parent as RecyclerView)
    }

    private fun setupTouchListener(recyclerView: RecyclerView) {
        recyclerView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP && currentlyShownItem != -1) {
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(currentlyShownItem)
                if (viewHolder != null) {
                    val itemView = viewHolder.itemView
                    // 检查是否点击在删除按钮区域
                    if (event.x >= itemView.right - deleteButtonWidth &&
                        event.x <= itemView.right &&
                        event.y >= itemView.top &&
                        event.y <= itemView.bottom
                    ) {
                        // 执行删除
                        onDelete(currentlyShownItem)
                        currentlyShownItem = -1
                        recyclerView.setOnTouchListener(null)
                        return@setOnTouchListener true
                    }
                }
                // 点击其他区域，恢复item
                recyclerView.adapter?.notifyItemChanged(currentlyShownItem)
                currentlyShownItem = -1
                recyclerView.setOnTouchListener(null)
            }
            false
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val itemView = viewHolder.itemView

        // 限制滑动距离
        val limitedDX = maxOf(dX, -deleteButtonWidth)

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            // 绘制红色背景
            val background = ColorDrawable(Color.parseColor("#FF3B30"))
            background.setBounds(
                itemView.right + limitedDX.toInt(),
                itemView.top,
                itemView.right,
                itemView.bottom
            )
            background.draw(c)

            // 绘制删除按钮文字
            if (limitedDX < 0) {
                val paint = Paint().apply {
                    color = Color.WHITE
                    textSize = 40f
                    textAlign = Paint.Align.CENTER
                    isAntiAlias = true
                }

                val text = "删除"
                val textY = itemView.top + (itemView.height + paint.textSize) / 2
                val textX = itemView.right - deleteButtonWidth / 2

                c.drawText(text, textX, textY, paint)
            }

            // 使用限制后的滑动距离
            super.onChildDraw(
                c, recyclerView, viewHolder, limitedDX, dY,
                actionState, isCurrentlyActive
            )
        }
    }

    override fun clearView(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ) {
        super.clearView(recyclerView, viewHolder)
        if (viewHolder.adapterPosition == currentlyShownItem) {
            recyclerView.setOnTouchListener(null)
            currentlyShownItem = -1
        }
    }
} 