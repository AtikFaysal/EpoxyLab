package com.atik.epoxypractice.epoxy

import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.databinding.ItemButtonBinding

class ButtonEpoxyModel(
    private val text : String
) : ViewBindingKotlinModel<ItemButtonBinding>(R.layout.item_button) {

    override fun ItemButtonBinding.bind() {
        textTv.text = text
    }
}