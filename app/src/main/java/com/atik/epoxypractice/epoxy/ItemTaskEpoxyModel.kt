package com.atik.epoxypractice.epoxy

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.data.TaskEntity
import com.atik.epoxypractice.databinding.ItemVerticalBinding

data class ItemTaskEpoxyModel(
    val taskEntity: TaskEntity,
    val onItemClick : (View.OnClickListener)
) : ViewBindingKotlinModel<ItemVerticalBinding>(R.layout.item_vertical) {

    override fun ItemVerticalBinding.bind() {
        iconIv.setImageDrawable(ContextCompat.getDrawable(root.context, taskEntity.icon))
        titleTv.text = taskEntity.title
        buttonTv.text = taskEntity.buttonText

        if(taskEntity.isItemSelect){
            root.backgroundTintList = ContextCompat.getColorStateList(root.context, R.color.black)
            titleTv.setTextColor(ContextCompat.getColor(root.context, R.color.white))
            buttonTv.setTextColor(ContextCompat.getColor(root.context, R.color.white))
            TextViewCompat.setCompoundDrawableTintList(buttonTv, ContextCompat.getColorStateList(root.context, R.color.white))
            iconIv.setColorFilter(ContextCompat.getColor(root.context, R.color.white))
        }
        else {
            root.backgroundTintList = ContextCompat.getColorStateList(root.context, R.color.white)
            titleTv.setTextColor(ContextCompat.getColor(root.context, R.color.black))
            buttonTv.setTextColor(ContextCompat.getColor(root.context, R.color.black))
            TextViewCompat.setCompoundDrawableTintList(buttonTv, ContextCompat.getColorStateList(root.context, R.color.black))
            iconIv.setColorFilter(ContextCompat.getColor(root.context, R.color.black))
        }

        root.setOnClickListener(onItemClick)
    }
}