package com.example.freshy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.markets_main.*

class markets_main : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.markets_main)
        val keyOne="feed_id"
        var keyTwo="feed_type"
        var type="market"
        btnCommodity.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"commodities")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
        btnBussNews.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"business")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
        btnStocks.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"buzzingstocks")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
        btnTech.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"technology")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
        btnGblmkts.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"internationalmarkets")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
        btnCurrency.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"currency")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
        btnEconomy.setOnClickListener{
            val intent=Intent(this,marketview::class.java)
            intent.putExtra(keyOne,"economy")
            intent.putExtra(keyTwo,type)
            startActivity(intent)
        }
    }

}