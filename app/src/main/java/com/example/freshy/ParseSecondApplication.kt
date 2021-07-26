package com.example.freshy

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.lang.Exception

class FeedSecondEntry {
    var name: String = ""
    var artist: String = ""
    var summary: String = ""
    var rights:String=""
    override fun toString(): String {
        return """
            Name= $name
            Release Date= $rights
            Summary =$summary
            Artist=$artist
         """.trimIndent()
    }
}
class ParseSecondApplication {
    val applicationsSec = ArrayList<FeedSecondEntry>()
    fun parseSec(xmlData: String): Boolean {
        var status = true
        var isEntry = false
        var textValue = ""
        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())
            var eventType = xpp.eventType
            var currentRecord=FeedSecondEntry()
            Log.d(TAG, "Ready to Parse")
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = xpp.name?.toLowerCase()
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if (tagName == "entry") {
                            isEntry = true
                        }
                    }
                    XmlPullParser.TEXT -> textValue = xpp.text
                    XmlPullParser.END_TAG -> {
                        Log.d(TAG, "parse: Ending tag for $tagName")
                        if (isEntry) {
                            when (tagName) {
                                "entry" -> {
                                    applicationsSec.add(currentRecord)
                                    isEntry = false
                                    currentRecord = FeedSecondEntry()
                                }
                                "title" -> currentRecord.name= textValue
                                "summary" -> currentRecord.summary = textValue
                                "artist"->currentRecord.artist=textValue
                                "rights"->currentRecord.rights=textValue
                            }
                            Log.d(TAG, textValue)
                        }
                    }
                }
                eventType = xpp.next()
            }
            for (app in applicationsSec) {
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