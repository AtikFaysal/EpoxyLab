package com.atik.epoxypractice.epoxy

import androidx.core.content.ContextCompat
import com.atik.epoxypractice.R
import com.atik.epoxypractice.ViewBindingKotlinModel
import com.atik.epoxypractice.data.UserEntity
import com.atik.epoxypractice.databinding.ItemCaroselBinding
import com.bumptech.glide.Glide

class ItemEpoxyHorizontalModel(
    private var userEntity: UserEntity,
    private val onTaskSelected:(item: UserEntity)->Unit
) : ViewBindingKotlinModel<ItemCaroselBinding>(R.layout.item_carosel) {

    override fun ItemCaroselBinding.bind() {

        fullNameTv.text = userEntity.fullName
        designationTv.text = userEntity.designation

        if(userEntity.itemClicked)
            statusIv.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.baseline_check_circle_24))
        else statusIv.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.baseline_add_circle_24))

        Glide
            .with(root.context)
            .load(userEntity.avatarUrl)
            .placeholder(R.drawable.baseline_person_24)
            .into(userAvatarIv)

        statusIv.setOnClickListener{
            onTaskSelected.invoke(userEntity)
        }
    }

    fun modifyData(user : UserEntity){
        userEntity = user
    }
}