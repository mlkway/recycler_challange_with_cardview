package com.raywenderlich.todolist_for_recycler_chalange

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TaskList
    ( val name: String,
      val task: String,
      val img:Int? = null):Parcelable
