package com.raywenderlich.todolist_for_recycler_chalange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.todolist_for_recycler_chalange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var taskList = mutableListOf<TaskList>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }


    private fun init(){

        makeRecycler()



        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, TASK_REQUEST_CODE)
        }

    }



    private fun makeRecycler(){
        setData()
        adapter = TaskAdapter(taskList, object :TaskItemListener{
            override fun userItemOnClick(position: Int) {
                val intent = Intent(this@MainActivity, ReadTaskActivity::class.java)
                intent.putExtra("task", taskList[position])

                startActivity(intent)
            }

            override fun userItemLongClick(position: Int) {
                taskList.removeAt(position)
                adapter.notifyItemRemoved(position)
            }

        })
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
        binding.recyclerView.adapter = adapter
    }


    private fun setData(){

        taskList.add(TaskList("sayidlebi","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", R.mipmap.information))
        taskList.add(TaskList("saxlis sakmeebi","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("samecadino","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("daleva","sadasdasdas",R.mipmap.information))
        taskList.add(TaskList("pexburtis yureba","sadasdasdas"))
        taskList.add(TaskList("meilis gagzavna","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas",R.mipmap.information))
        taskList.add(TaskList("saxlis sakmeebi","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("samecadino","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("daleva","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("pexburtis yureba","sadasdasdas"))
        taskList.add(TaskList("meilis gagzavna","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("saxlis sakmeebi","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("samecadino","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("daleva","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("pexburtis yureba","sadasdasdas"))
        taskList.add(TaskList("meilis gagzavna","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("saxlis sakmeebi","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("samecadino","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("daleva","sadasdasdas", R.mipmap.information))
        taskList.add(TaskList("pexburtis yureba","sadasdasdas"))
        taskList.add(TaskList("meilis gagzavna","sadasdasdas"))
        taskList.add(TaskList("sayidlebi","sadasdasdas"))

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TASK_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                val task = data?.getParcelableExtra<TaskList>("task")

                taskList.add(task!!)
                adapter.notifyItemInserted(taskList.lastIndex)

            }
        }


    }


    companion object {
        const val TASK_REQUEST_CODE = 0
    }


}