package com.example.recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var layout: RecyclerView.LayoutManager? = null
    private var switch: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ActivityMainBinding

    var vm = MainViewModel.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.createArr()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layout = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layout
        switch = RecyclerAdapter()
        binding.contentMain.recyclerView.adapter = switch
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}