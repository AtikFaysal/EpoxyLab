package com.atik.epoxypractice.epoxy

import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.databinding.ItemTitleRegulerBinding

class HeaderTitleRegularEpoxyModel (
    private val title : String,
) : ViewBindingKotlinModel<ItemTitleRegulerBinding>(R.layout.item_title_reguler) {

    override fun ItemTitleRegulerBinding.bind() {
        titleTv.text = title
    }
}