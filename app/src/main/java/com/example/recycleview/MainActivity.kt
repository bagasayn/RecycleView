package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbersList: RecyclerView = findViewById(R.id.rv_numbers) // создаем обект для Kotlin

        val layoutManager = LinearLayoutManager(this)
        numbersList.layoutManager = layoutManager // передаем содержимое списка

        numbersList.setHasFixedSize(true) // заранее говорим, что знаем размер списка, ускоряет работу

        val numbersAdaptor = NumbersAdaptor(100)
        numbersList.adapter = numbersAdaptor

    }
}