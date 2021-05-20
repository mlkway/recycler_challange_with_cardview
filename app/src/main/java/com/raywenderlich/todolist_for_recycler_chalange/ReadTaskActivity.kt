package com.raywenderlich.todolist_for_recycler_chalange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.todolist_for_recycler_chalange.databinding.ActivityReadTaskBinding

class ReadTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }


    private fun init(){

        val task = intent.getParcelableExtra<TaskList>("task")

        binding.taskNameTextView.text = task?.name
        binding.taskTextViev.text = task?.task


    }

}