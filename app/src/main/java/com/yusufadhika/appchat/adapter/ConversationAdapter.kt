package com.yusufadhika.appchat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yusufadhika.appchat.R
import com.yusufadhika.appchat.data.Message

class ConversationAdapter(private val messages: ArrayList<Message>, val userId: String?) :
    RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder>() {

    companion object {
        val MESSAGE_CURRENT_USER = 1
        val MESSAGE_OTHER_USER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        if (viewType == MESSAGE_CURRENT_USER) {
            return ConversationViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user_message, parent, false)
            )
        } else {
            return ConversationViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_other_message, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        holder.bindItem(messages[position])
    }

    override fun getItemCount() = messages.size

    override fun getItemViewType(position: Int): Int {
        if (messages[position].sentBy.equals(userId)) {
            return MESSAGE_CURRENT_USER
        } else {
            return MESSAGE_OTHER_USER
        }
    }

    fun addMessage(message: Message) {
        messages.add(message)
        notifyDataSetChanged()
    }

    class ConversationViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(message: Message) {
            view.findViewById<TextView>(R.id.txt_message).text = message.message
        }

    }
}
