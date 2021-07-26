package com.example.freshy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var calender:Calendar= Calendar.getInstance()
        var curDate=DateFormat.getDateInstance(DateFormat.FULL).format(calender.time)
        var listOne=curDate.split(",")
        Date.text=listOne[1].split(" ")[1]+" "+listOne[1].split(" ")[2]
        Time.text=listOne[0]
        Year.text=listOne[2]
        btnNews.setOnClickListener(this)
        btnMarkets.setOnClickListener(this)
        btnOthers.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.btnNews -> Intent(this, news_main::class.java)
            R.id.btnMarkets -> Intent(this, markets_main::class.java)
            R.id.btnOthers -> Intent(this, others_main::class.java)
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}