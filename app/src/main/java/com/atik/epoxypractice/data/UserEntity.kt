package com.atik.epoxypractice.data

data class UserEntity(
    val userId : String,
    val fullName : String,
    val designation : String,
    val avatarUrl : String,
    var itemClicked : Boolean
){
    override fun toString(): String {
        return "$itemClicked"
    }
}