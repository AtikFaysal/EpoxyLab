package com.atik.epoxypractice.data

data class TaskEntity(
    val id : Int,
    val title : String,
    val buttonText : String,
    var isItemSelect : Boolean
)