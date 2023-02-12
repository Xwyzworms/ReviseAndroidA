package com.example.revisitingandroid.main.contents.viewModels

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.viewModels.v_1.ViewMActivity
import com.example.revisitingandroid.main.contents.viewModels.v_2.ViewMAFActivity

class ViewModelsAdapter(private val context : Context, private val listContents : ArrayList<String>)  :
            RecyclerView.Adapter<ViewModelsAdapter.ViewHolder>()
{
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        fun bind(textString : String, position: Int)
        {
            val textView : TextView = itemView.findViewById(R.id.tv_vmRctitleContent)
            textView.text = textString
            setOnClickListener(position)
        }
        fun setOnClickListener(position: Int )
        {
            var intent : Intent = Intent()
            itemView.setOnClickListener {
                if(position == 0)
                {
                    intent = Intent(context, ViewMActivity::class.java)
                    context.startActivity(intent)
                }
                else if(position == 1)
                {
                    intent=Intent(context, ViewMAFActivity::class.java)
                    context.startActivity(intent)
                }
                else if(position == 2)
                {

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.vmactivity_rc_content, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listContents[position],position)
    }

    override fun getItemCount(): Int {
        return listContents.size
    }
}