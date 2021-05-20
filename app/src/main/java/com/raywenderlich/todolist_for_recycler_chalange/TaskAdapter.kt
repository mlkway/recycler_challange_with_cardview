package com.raywenderlich.todolist_for_recycler_chalange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.todolist_for_recycler_chalange.databinding.ImportantItemTaskBinding
import com.raywenderlich.todolist_for_recycler_chalange.databinding.NotImportantTaskBinding

class TaskAdapter
    (private val data: MutableList<TaskList>,
     private val taskItemListener: TaskItemListener
     ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1){
            NotImportantTaskViewHolder(
                NotImportantTaskBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }else{
            ImportantTaskViewHolder(
                ImportantItemTaskBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImportantTaskViewHolder){
            holder.bind()
        }else if (holder is NotImportantTaskViewHolder){
            holder.bind()
        }
    }

    override fun getItemCount() = data.size


    inner class ImportantTaskViewHolder
        (private val binding: ImportantItemTaskBinding
        ):RecyclerView.ViewHolder(binding.root),View.OnClickListener,View.OnLongClickListener{
            fun bind(){
                binding.taskNameTextView.text = data[adapterPosition].name
                binding.imageView.setImageResource(data[adapterPosition].img!!)
                binding.root.setOnLongClickListener(this)
                binding.root.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            taskItemListener.userItemOnClick(adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            taskItemListener.userItemLongClick(adapterPosition)
            return true
        }
    }

    inner class NotImportantTaskViewHolder
        (private val  binding: NotImportantTaskBinding
        ):RecyclerView.ViewHolder(binding.root),View.OnClickListener,View.OnLongClickListener{
           private lateinit var taskData: TaskList
            fun bind(){
                taskData = data[adapterPosition]
                binding.taskNameTextView.text = taskData.name
                binding.root.setOnClickListener(this)
                binding.root.setOnLongClickListener(this)
            }

        override fun onClick(v: View?) {
            taskItemListener.userItemOnClick(adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            taskItemListener.userItemLongClick(adapterPosition)
            return true
        }
    }


    override fun getItemViewType(position: Int): Int {
        val task = data[position]

        return if (task.img == null) 1 else 2
    }




}