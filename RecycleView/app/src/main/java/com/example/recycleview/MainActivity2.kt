package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycleview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity()  {
    private lateinit var binding: ActivityMain2Binding
    var data = Data.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras?: return
        val  titleString = extras.getInt("title")
        val  detailsString = extras.getInt("details")
        val  imageResource = extras.getInt("image")
        binding.textView.text = data.names[titleString]
        binding.textView2.text = data.info[detailsString]
        binding.imageView.setImageResource(data.pictures[imageResource])
    }
}