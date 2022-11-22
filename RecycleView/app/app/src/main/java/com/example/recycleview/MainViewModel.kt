package com.example.recycleview

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    companion object {
        fun newInstance() = MainViewModel()
        var cardItems: ArrayList<ArrayList<Int>> = arrayListOf()
    }

    fun createArr() {
        if (cardItems.size == 0) {
            for (i in 0..7)
                cardItems.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
        }
    }
}