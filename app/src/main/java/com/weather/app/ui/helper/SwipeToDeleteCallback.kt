package com.weather.app.ui.helper

import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeToDeleteCallback(
    private val onDelete: (Int) -> Unit,
    private val onDetail: (Int) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    private val deleteButtonWidth = 280f
    private val detailButtonWidth = 280f
    private var currentlyShownItem: Int = -1
    private var recyclerView: RecyclerView? = null
    private var isActionButtonClicked = false

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, 
        target: RecyclerView.ViewHolder) = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        currentlyShownItem = viewHolder.adapterPosition
        isActionButtonClicked = false
        setupTouchListener(viewHolder.itemView.parent as RecyclerView, direction)
    }

    private fun setupTouchListener(recyclerView: RecyclerView, direction: Int) {
        this.recyclerView = recyclerView
        val touchListener = View.OnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP && currentlyShownItem != -1) {
                val viewHolder = (view as RecyclerView).findViewHolderForAdapterPosition(currentlyShownItem)
                if (viewHolder != null) {
                    val itemView = viewHolder.itemView
                    when (direction) {
                        ItemTouchHelper.LEFT -> {
                            // 检查是否点击在删除按钮区域
                            if (event.x >= itemView.right - deleteButtonWidth &&
                                event.x <= itemView.right &&
                                event.y >= itemView.top &&
                                event.y <= itemView.bottom
                            ) {
                                isActionButtonClicked = true
                                onDelete(currentlyShownItem)
                                resetState()
                                return@OnTouchListener true
                            }
                        }
                        ItemTouchHelper.RIGHT -> {
                            // 检查是否点击在详情按钮区域
                            if (event.x >= itemView.left &&
                                event.x <= itemView.left + detailButtonWidth &&
                                event.y >= itemView.top &&
                                event.y <= itemView.bottom
                            ) {
                                isActionButtonClicked = true
                                onDetail(currentlyShownItem)
                                // 不要在这里调用 resetState()
                                return@OnTouchListener true
                            }
                        }
                    }
                }
                // 只有在没有点击操作按钮时才重置状态
                if (!isActionButtonClicked) {
                    (view as RecyclerView).adapter?.notifyItemChanged(currentlyShownItem)
                    resetState()
                }
            }
            false
        }
        recyclerView.setOnTouchListener(touchListener)
    }

    private fun resetState() {
        currentlyShownItem = -1
        isActionButtonClicked = false
        recyclerView?.setOnTouchListener(null)
        recyclerView = null
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

        when {
            dX < 0 -> { // 左滑删除
                val limitedDX = maxOf(dX, -deleteButtonWidth)
                
                // 绘制红色背景
                val background = ColorDrawable(Color.parseColor("#FF3B30"))
                background.setBounds(
                    itemView.right + limitedDX.toInt(),
                    itemView.top,
                    itemView.right,
                    itemView.bottom
                )
                background.draw(c)

                // 绘制删除文字
                if (limitedDX < 0) {
                    val paint = Paint().apply {
                        color = Color.WHITE
                        textSize = 40f
                        textAlign = Paint.Align.CENTER
                        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    }

                    val textY = itemView.top + (itemView.height + paint.textSize) / 2
                    val textX = itemView.right - deleteButtonWidth / 2
                    c.drawText("删除", textX, textY, paint)
                }

                super.onChildDraw(c, recyclerView, viewHolder, limitedDX, dY, actionState, isCurrentlyActive)
            }
            dX > 0 -> { // 右滑查看详情
                val limitedDX = minOf(dX, detailButtonWidth)
                
                // 绘制蓝色背景
                val background = ColorDrawable(Color.parseColor("#007AFF"))
                background.setBounds(
                    itemView.left,
                    itemView.top,
                    itemView.left + limitedDX.toInt(),
                    itemView.bottom
                )
                background.draw(c)

                // 绘制详情文字
                if (limitedDX > 0) {
                    val paint = Paint().apply {
                        color = Color.WHITE
                        textSize = 40f
                        textAlign = Paint.Align.CENTER
                        typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                    }

                    val textY = itemView.top + (itemView.height + paint.textSize) / 2
                    val textX = itemView.left + detailButtonWidth / 2
                    c.drawText("详情", textX, textY, paint)
                }

                super.onChildDraw(c, recyclerView, viewHolder, limitedDX, dY, actionState, isCurrentlyActive)
            }
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        // 只有在没有点击操作按钮时才重置状态
        if (viewHolder.adapterPosition == currentlyShownItem && !isActionButtonClicked) {
            resetState()
        }
    }
}