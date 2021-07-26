package com.example.freshy

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.lang.Exception
class FeedEntry {
    var title: String = ""
    var pubDate: String = ""
    var summary: String = ""
    var category:String=""
    var description: String = ""
    override fun toString(): String {
        return """
            Name= $title
            Release Date= $pubDate
            Summary =$summary
         """.trimIndent()
    }
}
class ParseApplications {
    val applications = ArrayList<FeedEntry>()
    fun parse(xmlData: String): Boolean {
        var status = true
        var isEntry = false
        var textValue = ""
        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())
            var eventType = xpp.eventType
            var currentRecord=FeedEntry()
            Log.d(TAG, "Ready to Parse")
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = xpp.name?.toLowerCase()
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if (tagName == "item") {
                            isEntry = true
                        }
                    }
                    XmlPullParser.TEXT -> textValue = xpp.text
                    XmlPullParser.END_TAG -> {
                        Log.d(TAG, "parse: Ending tag for $tagName")
                        if (isEntry) {
                            when (tagName) {
                                "item" -> {
                                    applications.add(currentRecord)
                                    isEntry = false
                                    currentRecord = FeedEntry()
                                }
                                "title" -> currentRecord.title= textValue
                                "pubdate" -> currentRecord.pubDate = textValue
                                "pubDate" -> currentRecord.pubDate = textValue
                                "updated" -> currentRecord.pubDate = textValue
                                "description" -> currentRecord.description = textValue
                                "summary" -> currentRecord.summary = textValue
                                "category"->currentRecord.category=textValue
                            }
                            Log.d(TAG, textValue)
                        }
                    }
                }
                eventType = xpp.next()
            }
            for (app in applications) {
                Log.d(TAG, "*******************")
                Log.d(TAG, app.toString())
            }


        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }
        return status
    }
}