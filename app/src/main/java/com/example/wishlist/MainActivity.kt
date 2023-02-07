package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
     private var items: MutableList<Item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.submit)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val urlInput = findViewById<EditText>(R.id.urlInput)
        val priceInput = findViewById<EditText>(R.id.priceInput)

        //Lookup the RecyclerView
        val itemsRv = findViewById<RecyclerView>(R.id.itemsrV)

        // create adapter passing in the list of items
        val adapter = ItemAdapter(items)

        //Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter

        //set layout manager to position items
        itemsRv.layoutManager = LinearLayoutManager(this)

        submit.setOnClickListener{
            var name = nameInput.text.toString()
            var url = urlInput.text.toString()
            var price = priceInput.text.toString()

            val item = Item(name,price,url)
            items.add(item)
            adapter.notifyDataSetChanged()
        }
    }
}