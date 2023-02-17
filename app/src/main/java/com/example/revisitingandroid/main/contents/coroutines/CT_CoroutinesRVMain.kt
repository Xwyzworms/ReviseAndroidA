package com.example.revisitingandroid.main.contents.coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R

class CT_CoroutinesRVMain(listContents : ArrayList<String>, onClickListener : (Int) -> Unit ) : RecyclerView.Adapter<CoroutineViewHolder>()
{
    private var listContents : ArrayList<String>
    private val onClickListener : (Int) -> Unit

    init {
        this.listContents = listContents
        this.onClickListener =onClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoroutineViewHolder {
        val viewCoroutineViewHolder : View = LayoutInflater.from(parent.context).inflate(R.layout.ct_coroutines_main_rv_content, parent, false)
        return CoroutineViewHolder(viewCoroutineViewHolder)
    }

    override fun getItemCount(): Int {
        return listContents.size
    }

    override fun onBindViewHolder(holder: CoroutineViewHolder, position: Int) {
        holder.bind(listContents[position],position, onClickListener)
    }

}
class CoroutineViewHolder(view : View) : RecyclerView.ViewHolder(view)
{
    fun bind(content : String, position: Int ,onClickListener: (Int) -> Unit)
    {
        val textView : TextView = itemView.findViewById(R.id.tv_CT_main_rv_content)
        textView.text = content
        itemView.setOnClickListener{
            onClickListener(position)
        }
    }
}
