package com.atik.epoxypractice.epoxy

import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.databinding.ItemTitleBinding

data class HeaderTitleEpoxyModel (
    private val title : String,
) : ViewBindingKotlinModel<ItemTitleBinding>(R.layout.item_title) {

    override fun ItemTitleBinding.bind() {
        titleTv.text = title
    }
}