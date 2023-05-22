package com.example.myapplication.presentation.recycler

fun createData (number: Int): Array<String> {
    val list = ArrayList<String>()
    for (i in 1..number) {
        list.add("Test data $i")
    }

    return list.toTypedArray()
}

val data = createData(100)