package com.atik.epoxypractice.epoxy

import android.view.View
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.atik.epoxypractice.data.TaskEntity
import com.atik.epoxypractice.data.UserEntity

class ItemEpoxyController(
    private val onItemSelected:(item:String)->Unit
) : EpoxyController(){

    var itemList = listOf<UserEntity>()
    var taskList = listOf<TaskEntity>()

    init {
        setFilterDuplicates(true)
    }

    override fun buildModels() {
        val itemViewList = mutableListOf<EpoxyModel<View>>()
        itemList.forEach { item->
            itemViewList.add(
                ItemEpoxyHorizontalModel(item){
                    onItemSelected.invoke("")
                }.id("carosel_host","${item.userId}")
            )
        }

        HeaderTitleEpoxyModel(
            "Horizontal Post View"
        ).id("title_id","horizontal_post_view").addTo(this)

        CarouselModel_()
            .id("item_carousel")
            .models(itemViewList)
            .addTo(this)

        HeaderTitleEpoxyModel(
            "Vertical Post View"
        ).id("title_id","vertical_post_view").addTo(this)

        taskList.forEach { item->
            ItemTaskEpoxyModel(item){
                onItemSelected.invoke(item.title)
            }.id("post_list", "${item.id}").addTo(this)
        }
    }
}