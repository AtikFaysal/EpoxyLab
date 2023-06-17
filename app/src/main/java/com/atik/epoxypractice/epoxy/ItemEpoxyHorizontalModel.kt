package com.atik.epoxypractice.epoxy

import android.view.View
import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.data.UserEntity
import com.atik.epoxypractice.databinding.ItemCaroselBinding
import com.squareup.picasso.Picasso

class ItemEpoxyHorizontalModel(
    private val userEntity: UserEntity,
    private val onItemClick : (View.OnClickListener)
) : ViewBindingKotlinModel<ItemCaroselBinding>(R.layout.item_carosel) {

    override fun ItemCaroselBinding.bind() {

        fullNameTv.text = userEntity.fullName
        designationTv.text = userEntity.designation

        Picasso.get()
            .load(userEntity.avatarUrl)
            .into(userAvatarIv)

        root.setOnClickListener(onItemClick)
    }
}