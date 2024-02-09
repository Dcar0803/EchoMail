package com.example.echomail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var emails: List<Email>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Lookups the RecyclerView in activity layout

        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        //Fetch the list of emails
        emails = EmailFetcher.getEmails()
        //Create adapter passing in the list of emails
        val adapter = EmailAdapter(emails)
        emailsRv.adapter = adapter
        //Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            // Fetch next 5 emails
            val newEmails = EmailFetcher.getNext5Emails()
            // Add new emails to existing list of emails
            (emails as MutableList<Email>).addAll(newEmails)
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }
    }
}