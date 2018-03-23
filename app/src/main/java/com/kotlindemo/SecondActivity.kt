package com.kotlindemo

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secoond)
        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val b = intent.extras
        val str = b.getString("data")
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()


        val fab = findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
