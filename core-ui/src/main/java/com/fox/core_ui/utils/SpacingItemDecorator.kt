package com.fox.core_ui.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecorator(private val offset: Int, private val type: SpacingType): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        when(type) {
            SpacingType.Vertical -> outRect.set(0, offset, 0, offset)
            SpacingType.Horizontal -> outRect.set(offset, 0, offset, 0)
            SpacingType.Left -> outRect.left = offset
            SpacingType.Right -> outRect.right = offset
            SpacingType.Top -> outRect.top = offset
            SpacingType.Bottom -> outRect.bottom = offset
            SpacingType.All -> outRect.set(offset, offset, offset, offset)
        }
    }
}