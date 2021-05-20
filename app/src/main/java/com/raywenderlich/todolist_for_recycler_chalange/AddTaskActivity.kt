package com.raywenderlich.todolist_for_recycler_chalange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.raywenderlich.todolist_for_recycler_chalange.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }


    private fun init(){

        binding.button.setOnClickListener {

            saveData()

        }

        binding.imageView2.setOnClickListener {
            onBackPressed()
        }




    }


    private fun saveData(){

        if (checkAllFields()){
            binding.apply {

                val task = TaskList(
                    name = taskNameEditText.text.toString(),
                    task = editTextTextMultiLine.text.toString(),
                    img = returnNullOrImg()
                )

                returnResult(task)



            }
        }else{
            makeToast("fill all fields")
        }
    }

    private fun  returnResult(task: TaskList){

        val intent = Intent()
        intent.putExtra("task", task)
        setResult(RESULT_OK, intent)
        finish()
    }



    private fun returnImportance():Boolean{
        return  binding.yesRadioButton.isChecked

    }

    private fun returnNullOrImg():Int?{
        var forReturn: Int? = null
        if (returnImportance()){
            forReturn = R.mipmap.information
        }

        return forReturn

    }



    private fun makeToast(str: String){
        Toast.makeText(this,str, Toast.LENGTH_SHORT).show()
    }


    private fun checkAllFields():Boolean{
        var forReturnType = false


        if (!binding.taskNameEditText.text.isNullOrBlank() && !binding.editTextTextMultiLine.text.isNullOrBlank()){
            if (binding.yesRadioButton.isChecked || binding.noRadioButton.isChecked){
                forReturnType = true
            }
        }

        return forReturnType

    }










}