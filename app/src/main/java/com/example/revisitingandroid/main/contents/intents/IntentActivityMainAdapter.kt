package com.example.revisitingandroid.main.contents.intents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R

class IntentActivityMainAdapter(
    private val listOfContents : ArrayList<String>,
    private val setOnClickListener : (Int) -> Unit
) : RecyclerView.Adapter<IntentActivityMainAdapter.IntentActivityViewHolder>()
{
    // Subclass the ViewHolder instance class
    inner class IntentActivityViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        fun bind(stringInformation : String, position : Int)
        {
            itemView.findViewById<TextView>(R.id.intent_tv_main_content).text = stringInformation
            itemView.setOnClickListener {
                setOnClickListener(position)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntentActivityViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.intent_rv_main_content, parent,false)
        return IntentActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfContents.size
    }

    override fun onBindViewHolder(holder: IntentActivityViewHolder, position: Int) {
        holder.bind(listOfContents[position], position)

    }


}