package com.example.recycleview

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var vm = MainViewModel
    var data = Data.newInstance()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cards, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = data.names[vm.cardItems[i][0]]
        viewHolder.itemInfo.text = data.info[vm.cardItems[i][1]]
        viewHolder.itemPictures.setImageResource(data.pictures[vm.cardItems[i][2]])
    }

    override fun getItemCount(): Int {
        return vm.cardItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemPictures: ImageView
        var itemName: TextView
        var itemInfo: TextView

        init {
            itemPictures = itemView.findViewById(R.id.itemImage)
            itemName = itemView.findViewById(R.id.itemTitle)
            itemInfo = itemView.findViewById(R.id.itemDetail)
            itemView.setOnClickListener{v: View ->
                val position: Int = adapterPosition
                var titleSelected = vm.cardItems[position][0]
                var detailSelected = vm.cardItems[position][1]
                var imageSelected = vm.cardItems[position][2]
                val i = Intent(v.context, MainActivity2::class.java)
                i.putExtra("title", titleSelected)
                i.putExtra("details", detailSelected)
                i.putExtra("image", imageSelected)
                ContextCompat.startActivity(v.context, i, null)
            }
        }
    }
}