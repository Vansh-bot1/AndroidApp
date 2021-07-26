package com.example.freshy

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.listview.*
import java.net.URL
import kotlin.properties.Delegates

class othersview : AppCompatActivity() {

    private var downloadData: DownloadOthersData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)
        var feedId=intent.getStringExtra("feed_id").toString()
        downloadUrl(feedId)
    }
    private fun downloadUrl(feedUrl: String) {
        downloadData = DownloadOthersData(this, xmlListView)
        downloadData?.execute(feedUrl)
    }
}
private class DownloadOthersData(context: Context, listView: ListView) :
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
        val parseApplications = ParseSecondApplication()
        parseApplications.parseSec(result)
//                val arrayAdapter = ArrayAdapter<FeedSecondEntry>(
//                    propContext,
//                    R.layout.list_record,                                 //InBuilt Adapter
//                    parseApplications.applicationsSec
//                )
//                propListView.adapter = arrayAdapter
        val feedAdapter = FeedAdapterSecond(
            propContext,
            R.layout.list_record,
            parseApplications.applicationsSec
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