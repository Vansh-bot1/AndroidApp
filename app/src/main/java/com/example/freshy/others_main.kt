package com.example.freshy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.news_main.*
import kotlinx.android.synthetic.main.others_main.*

class others_main:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.others_main)
        var key="feed_id"
        btnMovies.setOnClickListener {
            val intent = Intent(this, othersview::class.java)
            intent.putExtra(key, "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topMovies/xml")
            startActivity(intent)
        }
        btnSongs.setOnClickListener {
            val intent = Intent(this, othersview::class.java)
            intent.putExtra(key, "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=25/xml")
            startActivity(intent)
        }
        btnNR.setOnClickListener {
            val intent = Intent(this, marketview::class.java)
            intent.putExtra(key, "http://rss.itunes.apple.com/api/v1/in/movies/top-movies/all/25/explicit.rss")  //Using the marketview for this
            intent.putExtra("feed_type","others")
            startActivity(intent)
        }
        btnFA.setOnClickListener {
            val intent = Intent(this, othersview::class.java)
            intent.putExtra(key, "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=25/xml")
            startActivity(intent)
        }
        btnPA.setOnClickListener {
            val intent = Intent(this, othersview::class.java)
            intent.putExtra(key, "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/toppaidapplications/limit=25/xml")
            startActivity(intent)
        }
        btnHealth.setOnClickListener {
            val intent = Intent(this, marketview::class.java)//Sending it to marketView Bec of TOI
            intent.putExtra(key, "3908999")
            intent.putExtra("feed_type","news")
            startActivity(intent)
        }
    }
}