package com.example.revisitingandroid.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.revisitingandroid.R

/**
 *  This Class Responsible for Main Grid item viewer
 *
 * */
class MainGridAdapter( private val context : Context, private val arrOfContents : ArrayList<String> ) : BaseAdapter(){

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return arrOfContents.size
    }

    override fun getItem(p0: Int): Any {
        return -1
    }

    override fun getItemId(p0: Int): Long {
        return 0;
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewInflated : View = inflater.inflate(R.layout.grid_view_main_content, null)
        val textView : TextView = viewInflated.findViewById(R.id.tv_titleMenu)
        textView.text = arrOfContents[i]
        return viewInflated
    }
}