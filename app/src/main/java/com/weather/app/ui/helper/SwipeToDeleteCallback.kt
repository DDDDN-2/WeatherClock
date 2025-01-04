package com.weather.app.ui.helper

import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.view.MotionEvent
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeToDeleteCallback(
    private val onDelete: (Int) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

    private val deleteButtonWidth = 280f  // 增加按钮宽度
    private var currentlyShownItem: Int = -1
    private val cornerRadius = 16f  // 调整圆角
    private val iconSize = 28f  // 稍微增大图标
    private val margin = 12f  // 调整边距
    private val textSize = 42f  // 增大文字大小

    // 创建文字画笔
    private val textPaint = Paint().apply {
        isAntiAlias = true
        color = Color.WHITE
        textSize = this@SwipeToDeleteCallback.textSize
        textAlign = Paint.Align.CENTER
        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)  // 设置字体为粗体
    }

    // 删除图标路径
    private val deletePath = Path().apply {
        // 绘制垃圾桶图标
        moveTo(0f, 4f)
        lineTo(24f, 4f)
        moveTo(10f, 4f)
        lineTo(10f, 0f)
        lineTo(14f, 0f)
        lineTo(14f, 4f)
        moveTo(2f, 4f)
        lineTo(2f, 24f)
        quadTo(2f, 26f, 4f, 26f)
        lineTo(20f, 26f)
        quadTo(22f, 26f, 22f, 24f)
        lineTo(22f, 4f)
        // 垃圾桶内的线条
        moveTo(7f, 8f)
        lineTo(7f, 22f)
        moveTo(12f, 8f)
        lineTo(12f, 22f)
        moveTo(17f, 8f)
        lineTo(17f, 22f)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, 
        target: RecyclerView.ViewHolder) = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
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
        val limitedDX = maxOf(dX, -deleteButtonWidth)

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            // 绘制圆角矩形背景
            val paint = Paint().apply {
                isAntiAlias = true
                color = Color.parseColor("#FF3B30")
            }

            val buttonBounds = RectF(
                itemView.right.toFloat() + limitedDX,
                itemView.top.toFloat() + margin,
                itemView.right.toFloat() - margin,
                itemView.bottom.toFloat() - margin
            )

            c.drawRoundRect(buttonBounds, cornerRadius, cornerRadius, paint)

            // 绘制删除图标和文字
            if (limitedDX < 0) {
                paint.apply {
                    color = Color.WHITE
                    style = Paint.Style.STROKE
                    strokeWidth = 2f
                }

                // 绘制图标
                val centerX = itemView.right - deleteButtonWidth / 2
                val iconLeft = centerX - iconSize / 2
                val iconTop = itemView.top + (itemView.height / 2) - iconSize - 10f  // 向上移动一点

                c.save()
                c.translate(iconLeft, iconTop)
                c.scale(1f, 1f)  // 不缩放图标
                c.drawPath(deletePath, paint)
                c.restore()

                // 使用加粗文字画笔绘制文字
                val textY = itemView.top + (itemView.height / 2) + iconSize + 10f  // 向下移动一点
                c.drawText("删除", centerX, textY, textPaint)
            }

            super.onChildDraw(c, recyclerView, viewHolder, limitedDX, dY, actionState, isCurrentlyActive)
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