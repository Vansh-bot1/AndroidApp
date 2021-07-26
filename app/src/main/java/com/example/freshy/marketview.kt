package com.example.freshy

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.listview.*
import java.net.URL
import kotlin.properties.Delegates


class marketview : AppCompatActivity() {

    private var downloadData: DownloadData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)
        var feedId=intent.getStringExtra("feed_id")
        var feedType=intent.getStringExtra("feed_type")
        Log.d("IntentSuccess","tapped $feedId")
        if(feedType=="others"){
            downloadUrl(feedId.toString())
        }else if(feedType=="market"){
            downloadUrl("http://www.moneycontrol.com/rss/$feedId.xml")
        }
        else{
            downloadUrl("https://timesofindia.indiatimes.com/rssfeeds/$feedId.cms")
        }
    }

    private fun downloadUrl(feedUrl: String) {
        downloadData = DownloadData(this, xmlListView)
        downloadData?.execute(feedUrl)
    }
}

private class DownloadData(context: Context, listView: ListView) :
    AsyncTask<String, Void, String>() {
    private val TAG = "DownloadData"

    var propContext: Context by Delegates.notNull()
    var propListView: ListView by Delegates.notNull()

    init {
        propContext = context
        propListView = listView
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        val parseApplications = ParseApplications()
        parseApplications.parse(result)
        Log.d("MarketView","Data parsed")
//                val arrayAdapter = ArrayAdapter<FeedEntry>(
//                    propContext,
//                    R.layout.list_item,                                 //InBuilt Adapter
//                    parseApplications.applications
//                )
//                propListView.adapter = arrayAdapter
        val feedAdapter = FeedAdapter(
            propContext,
            R.layout.list_record,
            parseApplications.applications
        )   //CustomAdapter
        propListView.adapter = feedAdapter

    }

    override fun doInBackground(vararg url: String?): String {
        val rssFeed = downloadXML(url[0])
        return rssFeed
    }

    private fun downloadXML(urlPath: String?): String {
        return URL(urlPath).readText()
    }
}