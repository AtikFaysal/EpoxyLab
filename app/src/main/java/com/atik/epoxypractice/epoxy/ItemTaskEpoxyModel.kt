package com.atik.epoxypractice.epoxy

import android.view.View
import androidx.core.content.ContextCompat
import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.data.TaskEntity
import com.atik.epoxypractice.databinding.ItemVerticalBinding

data class ItemTaskEpoxyModel(
    val taskEntity: TaskEntity,
    val onItemClick : (View.OnClickListener)
) : ViewBindingKotlinModel<ItemVerticalBinding>(R.layout.item_vertical) {

    override fun ItemVerticalBinding.bind() {
        iconIv.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.baseline_add_24))
        titleTv.text = taskEntity.title
        buttonTv.text = taskEntity.buttonText

        root.setOnClickListener(onItemClick)
    }
}