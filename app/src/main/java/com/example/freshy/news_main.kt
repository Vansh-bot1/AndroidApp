package com.example.freshy

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.news_main.*

class news_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_main)
        var key = "feed_id"
        var keyTwo = "feed_type"
        var type = "news"

        btnCA.setOnClickListener {
            val intent = Intent(this, marketview::class.java)
            intent.putExtra(key, "-2128936835")
            intent.putExtra(keyTwo, type)
            startActivity(intent)
        }
        btnWN.setOnClickListener {
            val intent = Intent(this, marketview::class.java)
            intent.putExtra(key, "296589292")
            intent.putExtra(keyTwo, type)
            startActivity(intent)
        }
        btnTech.setOnClickListener {
            val intent = Intent(this, marketview::class.java)
            intent.putExtra(key, "66949542")
            intent.putExtra(keyTwo, type)
            startActivity(intent)
        }
        btnsprts.setOnClickListener {
            val intent = Intent(this, marketview::class.java)
            intent.putExtra(key, "4719148")
            intent.putExtra(keyTwo, type)
            startActivity(intent)
        }
        btnEN.setOnClickListener {
            val intent = Intent(this, marketview::class.java)
            intent.putExtra(key, "1081479906")
            intent.putExtra(keyTwo, type)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_states, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var key = "feed_id"
        var keyTwo = "feed_type"
        var type = "news"
        when (item.itemId) {
            R.id.mnuDelhi -> {
                val intent = Intent(this, marketview::class.java)
                intent.putExtra(key, "-2128839596")
                intent.putExtra(keyTwo, type)
                startActivity(intent)
            }
            R.id.mnuMumbai->{                val intent = Intent(this, marketview::class.java)
                intent.putExtra(key, "-2128838597")
                intent.putExtra(keyTwo, type)
                startActivity(intent)}
            R.id.mnuChennai->{                val intent = Intent(this, marketview::class.java)
                intent.putExtra(key, "2950623")
                intent.putExtra(keyTwo, type)
                startActivity(intent)}
            R.id.mnuBangalore->{                val intent = Intent(this, marketview::class.java)
                intent.putExtra(key, "-2128833038")
                intent.putExtra(keyTwo, type)
                startActivity(intent)}
            R.id.mnuHyd->{                val intent = Intent(this, marketview::class.java)
                intent.putExtra(key, "-2128816011")
                intent.putExtra(keyTwo, type)
                startActivity(intent)}
        }
        return true
    }
}