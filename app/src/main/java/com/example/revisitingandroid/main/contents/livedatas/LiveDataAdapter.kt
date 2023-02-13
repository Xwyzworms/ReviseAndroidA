package com.example.revisitingandroid.main.contents.livedatas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.livedatas.v_1.LVA_v1_activity

class LiveDataAdapter(
    private val context : Context,
    private val listOfContents : ArrayList<String>) : RecyclerView.Adapter<LiveDataAdapter.ViewHolderRC>()
{
    inner class ViewHolderRC(view: View) : RecyclerView.ViewHolder(view)
    {
        fun bind(contentStr : String, position: Int)
        {
            val textView : TextView = itemView.findViewById(R.id.tv_LVA)
            textView.text = contentStr
            itemView.setOnClickListener {
                setOnClickListener(position)
            }
        }
        private fun setOnClickListener(position: Int)
        {
            var intent : Intent = Intent()
            when(position)
            {
               0->
                {
                    intent = Intent(context, LVA_v1_activity::class.java)
                    context.startActivity(intent)
                }

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRC {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.activity_live_data_rc_content,parent, false)
        return ViewHolderRC(view)
    }

    override fun onBindViewHolder(holder: ViewHolderRC, position: Int) {
        holder.bind(listOfContents[position], position)
    }

    override fun getItemCount(): Int {
        return listOfContents.size
    }
}