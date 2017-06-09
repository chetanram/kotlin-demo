package com.kotlindemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


/**
 * Created by chetan on 1/6/17.
 */
class Adapter(private var context: Context, private var lists: List<String>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main, null)

        return view


    }

    override fun getItem(position: Int): Any {
        return lists.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return lists.size
    }
}