package com.example.revisitingandroid.main.contents.recyclerViews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R

class RV_RecyclerViewsAdapter(private val context : Context, private val listContents : ArrayList<String>,
            private val clickListener : (String) -> Unit) : RecyclerView.Adapter<RV_RecyclerViewsAdapter.RVViewHolder>()
{
    inner class RVViewHolder(val view  : View) : RecyclerView.ViewHolder(view)
    {
        // Describe an item view and metadata terkait lokasi dia pada recycler view
        // ya basically yang bertanggung jawab untuk setiap item view yang ditampilkan dan juga interaksinya
        public fun bind(stringContent : String, position: Int)
        {

            val tv : TextView = itemView.findViewById(R.id.tv_rvMainContent)
            tv.text = stringContent

            if(position %2 == 0 )
            {
                tv.setBackgroundColor(context.resources.getColor(R.color.purple_200))
            }
            itemView.setOnClickListener {
                clickListener(stringContent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        // Kayak buat UI Template nya disini
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_recycler_views_main_content,parent,false)
        return RVViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listContents.size
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(listContents[position],position)
    }


}