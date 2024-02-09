package com.example.echomail


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {//end of class


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        //TODO: Create member variables for any view that will be set as you render a  row

        init{
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)

        }

    }//end of ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        //Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        //Returns a new holder instance 
        return ViewHolder(contactView)
    }//end of onCreateViewHolder

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)
        //Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }
}