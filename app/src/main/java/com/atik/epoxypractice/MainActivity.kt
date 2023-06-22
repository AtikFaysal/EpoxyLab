package com.atik.epoxypractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atik.epoxypractice.data.TaskEntity
import com.atik.epoxypractice.data.UserEntity
import com.atik.epoxypractice.databinding.ActivityMainBinding
import com.atik.epoxypractice.epoxy.ItemEpoxyController
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var controller:ItemEpoxyController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller  = ItemEpoxyController({
            controller.requestModelBuild()
        },{
            controller.requestModelBuild()
        })

        controller.userList = userDataProvider()
        controller.taskList = taskDataProvider()

        binding.listRv.adapter = controller.adapter
        controller.requestModelBuild()
    }
}


fun userDataProvider() : List<UserEntity>{
    val users = ArrayList<UserEntity>()
    for (i in 0..10){
        users.add(
            UserEntity(
                userId = i,
                fullName = "Atik Faysal($i)",
                avatarUrl = "https://images.mubicdn.net/images/cast_member/2184/cache-2992-1547409411/image-w856.jpg",
                designation = "Software Eng",
                itemClicked = false
            )
        )
    }

    return users
}

fun taskDataProvider() : List<TaskEntity>{
    val task = ArrayList<TaskEntity>()
    for (i in 1..3){
        when (i) {
            1 -> {
                task.add(
                    TaskEntity(
                        id = i,
                        title = "When it happen",
                        buttonText = "4:00 PM",
                        icon = R.drawable.ic_clock,
                        isItemSelect = false
                    )
                )
            }
            2 -> {
                task.add(
                    TaskEntity(
                        id = i,
                        title = "Add a note",
                        buttonText = "Add",
                        icon = R.drawable.baseline_more_horiz_24,
                        isItemSelect = false
                    )
                )
            }
            else -> {
                task.add(
                    TaskEntity(
                        id = i,
                        title = "Attendees",
                        buttonText = "Add",
                        icon = R.drawable.baseline_account_circle_24,
                        isItemSelect = false
                    )
                )
            }
        }
    }

    return task
}