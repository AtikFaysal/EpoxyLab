package com.atik.epoxypractice.epoxy

import android.view.View
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.atik.epoxypractice.data.TaskEntity
import com.atik.epoxypractice.data.UserEntity
import java.util.UUID

class ItemEpoxyController : EpoxyController(){

    var userList = listOf<UserEntity>()
    var taskList = listOf<TaskEntity>()

    init {
        setFilterDuplicates(true)
    }

    override fun buildModels() {
        val itemViewList = mutableListOf<EpoxyModel<View>>()

        HeaderTitleEpoxyModel(
            "Add a new task"
        ).id("title_id","bold_text_title").addTo(this)

        userList.forEach { item->
            itemViewList.add(
                ItemEpoxyHorizontalModel(item){
                    it.itemClicked = !it.itemClicked
                    notifyModelChanged(0)
                }.id("carosel_host", UUID.randomUUID().toString())
            )
        }

        CarouselModel_()
            .id("item_carousel")
            .models(itemViewList)
            .addTo(this)

        HeaderTitleRegularEpoxyModel(
            "Close all personal task"
        ).id("title_id","regular_text_title").addTo(this)

        taskList.forEach { item->
            ItemTaskEpoxyModel(item){
                item.isItemSelect = !item.isItemSelect
                requestModelBuild()
            }.id("post_list", UUID.randomUUID().toString()).addTo(this)
        }

        ButtonEpoxyModel(
            "Confirm task"
        ).id("title_id","button_").addTo(this)
    }
}

