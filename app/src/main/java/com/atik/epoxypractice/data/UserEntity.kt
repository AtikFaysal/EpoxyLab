package com.atik.epoxypractice.data

data class UserEntity(
    val userId : Int,
    val fullName : String,
    val designation : String,
    val avatarUrl : String,
    var itemClicked : Boolean
)
