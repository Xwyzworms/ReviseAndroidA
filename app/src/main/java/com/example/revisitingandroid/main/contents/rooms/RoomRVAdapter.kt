package com.example.revisitingandroid.main.contents.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.RvRoomMainContentBinding
import com.example.revisitingandroid.main.contents.rooms.rooms_db.Subscriber


class RoomRVAdapter(private val listItems : List<Subscriber>) : RecyclerView.Adapter<RoomRVAdapter.ViewHolderRoom>()
{
    inner class ViewHolderRoom(view : View) : RecyclerView.ViewHolder(view)
    {
        fun bind(subscriber: Subscriber)
        {
            val tvName : TextView = this.itemView.findViewById(R.id.tv_rv_content_name)
            val tvEmail : TextView = this.itemView.findViewById(R.id.tv_rv_content_email)

            tvName.text = subscriber.name
            tvEmail.text=subscriber.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRoom {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rv_room_main_content, parent, false)
        return ViewHolderRoom(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolderRoom, position: Int)
    {
        holder.bind(listItems[position])

    }
}