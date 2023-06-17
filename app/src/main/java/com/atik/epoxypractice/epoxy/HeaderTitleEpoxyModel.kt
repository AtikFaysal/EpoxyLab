package com.atik.epoxypractice.epoxy

import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.databinding.ItemTitleBoldBinding

data class HeaderTitleEpoxyModel (
    private val title : String,
) : ViewBindingKotlinModel<ItemTitleBoldBinding>(R.layout.item_title_bold) {

    override fun ItemTitleBoldBinding.bind() {
        titleTv.text = title
    }
}