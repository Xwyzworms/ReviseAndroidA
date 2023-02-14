package com.example.revisitingandroid.main.contents.navigations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R

class HomeFragmentNavAdapter(private val navController: NavController ,
                             private val listContents: ArrayList<String>
) : RecyclerView.Adapter<HomeFragmentNavAdapter.ViewHolderAdapter>()
{
    inner class ViewHolderAdapter(view : View) : RecyclerView.ViewHolder(view)
    {
        fun bind(content : String, position: Int)
        {
            val textView : TextView = itemView.findViewById(R.id.tv_homeNav_rc)
            textView.text = content
            itemView.setOnClickListener {
                setOnClickListener(position)
            }
        }

        private fun setOnClickListener(position : Int) {
            if(position == 0)
            {
                navController.navigate(R.id.action_homeFragmentNavMain_to_homeFragment_NV)
            }
            else if(position == 1)
            {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home_nav_rc_content,parent,false)
        return ViewHolderAdapter(view)
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.bind(listContents[position], position)
    }

    override fun getItemCount(): Int {
        return listContents.size
    }
}