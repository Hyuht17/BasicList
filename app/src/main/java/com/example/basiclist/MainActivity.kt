package com.example.basiclist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listview)
        val editText = findViewById<EditText>(R.id.editText)
        val sochan = findViewById<RadioButton>(R.id.sochan)
        val sole = findViewById<RadioButton>(R.id.sole)
        val sochinhphuong = findViewById<RadioButton>(R.id.sochinhphuong)
        val showButton = findViewById<Button>(R.id.button)
        val thongbaoTextView = findViewById<TextView>(R.id.thongbao)

        showButton.setOnClickListener {
            val inputText = editText.text.toString()
            if (inputText.isEmpty() || inputText.toIntOrNull() == null) {
                thongbaoTextView.text = "Vui lòng nhập số nguyên dương hợp lệ"
                return@setOnClickListener
            }

            val n = inputText.toInt()
            if (n <= 0){
                thongbaoTextView.text = "Vui lòng nhập số nguyên dương"
                return@setOnClickListener
            }

            val resultList = when {
                sochan.isChecked -> getSoChanList(n)
                sole.isChecked -> getSoLeList(n)
                sochinhphuong.isChecked -> getSoChinhPhuongList(n)
                else -> {
                    thongbaoTextView.text = "Vui lòng chọn loại số"
                    return@setOnClickListener
                }
            }
            thongbaoTextView.text = ""
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, resultList)
            listView.adapter = adapter
        }
    }

    private fun getSoChanList(n: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0..n step 2){
            list.add(i)
        }
        return list
    }

    private fun getSoLeList(n: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 1..n step 2){
            list.add(i)
        }
        return list
    }

    private fun getSoChinhPhuongList(n: Int): List<Int> {
        val list = mutableListOf<Int>()
        var i = 1
        while (i * i < n){
            list.add(i * i)
            i++
        }
        return list
    }
}