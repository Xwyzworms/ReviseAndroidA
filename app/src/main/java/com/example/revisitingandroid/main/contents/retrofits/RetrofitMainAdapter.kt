package com.example.revisitingandroid.main.contents.retrofits

/*
##################################################
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown
#       Text editor : AndroidStudio + VIM
##################################################
*/

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.retrofits.data.Album
import com.example.revisitingandroid.main.contents.retrofits.data.Albums
import com.example.revisitingandroid.main.contents.viewModels.ViewModelsAdapter

public class RetrofitMainAdapter(
        private val listContents : List<Album>


) : RecyclerView.Adapter<RetrofitMainAdapter.RetrofitViewHolder>()
{
    inner class RetrofitViewHolder (view : View) : RecyclerView.ViewHolder(view)
    {
        public fun bind(album : Album)
        {
            val textView : TextView = this.itemView.findViewById(R.id.tv_retrofit_main_text)
            textView.text = StringBuilder().apply {
                append(album.id)
                append(" ")
                append(album.title)
            }.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder
    {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_activity_retrofit_main_content, parent, false)
        return RetrofitViewHolder(view)

    }

    override fun getItemCount(): Int
    {
        return listContents.size
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        holder.bind(listContents[position])
    }

}