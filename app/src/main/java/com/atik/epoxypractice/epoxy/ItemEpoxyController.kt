package com.atik.epoxypractice.epoxy

import android.util.Log
import android.view.View
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.atik.epoxypractice.data.TaskEntity
import com.atik.epoxypractice.data.UserEntity

class ItemEpoxyController(
    private val onUserSelected:(user:UserEntity)->Unit,
    private val onTaskSelected:(task:TaskEntity)->Unit,
) : EpoxyController(){

    var selectedUser = -1
    var userList = listOf<UserEntity>()
    var selectedTask = -1
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
                ItemEpoxyHorizontalModel(true,item){
                    Log.d("---->","clicked")
                    selectedUser = item.userId
                    onUserSelected.invoke(item)
                }.id("carosel_host", item.userId.toString())
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
            ItemTaskEpoxyModel(item.id == selectedTask, item){
                selectedTask = item.id
                onTaskSelected.invoke(item)
            }.id("post_list",item.id.toString()).addTo(this)
        }

        ButtonEpoxyModel(
            "Confirm task"
        ).id("title_id","button_").addTo(this)
    }
}

