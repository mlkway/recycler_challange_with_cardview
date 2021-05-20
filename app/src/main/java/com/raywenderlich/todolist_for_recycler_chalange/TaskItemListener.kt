package com.raywenderlich.todolist_for_recycler_chalange

interface TaskItemListener {

    fun userItemOnClick(position:Int)

    fun userItemLongClick(position: Int)

}